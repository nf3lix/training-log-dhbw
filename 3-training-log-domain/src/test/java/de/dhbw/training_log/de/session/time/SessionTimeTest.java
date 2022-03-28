package de.dhbw.training_log.de.session.time;

import de.dhbw.training_log.de.test_utils.ValueObjectTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static de.dhbw.training_log.de.session.time.SessionTimeMatcher.hasTime;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SessionTimeTest {

    @Test
    public void throwExceptionWhenSecondsIsNegative() {
        assertThrows(IllegalStateException.class, () -> new Seconds(-1));
    }

    @Test
    public void throwExceptionWhenMinutesIsNegative() {
        assertThrows(IllegalStateException.class, () -> new Minutes(-1));
    }

    @Test
    public void assignMinutesAndSecondsToSessionTime() {
        for(int minutes = 0; minutes < 6; minutes++) {
            final Integer seconds = 10 * minutes;
            final SessionTime sessionTime = new SessionTime(new Minutes(minutes), new Seconds(seconds));
            assertThat(sessionTime, hasTime(minutes, seconds));
        }
    }

    @Test
    public void rebalanceSecondsOfSessionTime() {
        final SessionTime sessionTime = new SessionTime(new Minutes(1), new Seconds(61));
        assertThat(sessionTime, hasTime(2, 1));
    }

    @Test
    public void addSessionTimes() {
        final SessionTime sessionTime1 = new SessionTime(new Minutes(2), new Seconds(20));
        final SessionTime sessionTime2 = new SessionTime(new Minutes(3), new Seconds(20));
        final SessionTime sessionTime3 = new SessionTime(new Minutes(4), new Seconds(40));
        assertThat(sessionTime1.add(sessionTime2), hasTime(5, 40));
        assertThat(sessionTime1.add(sessionTime3), hasTime(7, 0));
    }

    @Test
    public void divideSessionTime() {
        final SessionTime sessionTime1 = new SessionTime(new Minutes(2), new Seconds(20));
        final SessionTime sessionTime2 = new SessionTime(new Minutes(3), new Seconds(20));
        final SessionTime sessionTime3 = new SessionTime(new Minutes(4), new Seconds(40));
        assertThat(sessionTime1.divideBy(20.0), hasTime(0, 7));
        assertThat(sessionTime2.divideBy(2.0), hasTime(1, 40));
        assertThat(sessionTime3.divideBy(4.0), hasTime(1, 10));
    }

    @Test
    public void compareSessionTimes() {
        final List<SessionTime> sessionTimes = new ArrayList<>();
        sessionTimes.add(new SessionTime(new Minutes(3), new Seconds(20)));
        sessionTimes.add(new SessionTime(new Minutes(2), new Seconds(20)));
        sessionTimes.add(new SessionTime(new Minutes(5), new Seconds(10)));
        sessionTimes.add(new SessionTime(new Minutes(4), new Seconds(40)));
        final List<SessionTime> sortedList = sessionTimes.stream().sorted().collect(Collectors.toList());
        assertEquals(sortedList.get(0), new SessionTime(new Minutes(2), new Seconds(20)));
        assertEquals(sortedList.get(1), new SessionTime(new Minutes(3), new Seconds(20)));
        assertEquals(sortedList.get(2), new SessionTime(new Minutes(4), new Seconds(40)));
        assertEquals(sortedList.get(3), new SessionTime(new Minutes(5), new Seconds(10)));
    }

    @Test
    public void sessionTimeValueObjectBehavior() {
        final List<Supplier<SessionTime>> sessionTimes = Arrays.asList(
                () -> new SessionTime(new Minutes(2), new Seconds(20)),
                () -> new SessionTime(new Minutes(3), new Seconds(20)),
                () -> new SessionTime(new Minutes(2), new Seconds(30)),
                () -> new SessionTime(new Minutes(3), new Seconds(30))
        );
        ValueObjectTest.performValueObjectTest(sessionTimes);
    }

    @Test
    public void minutesValueObjectBehavior() {
        final List<Supplier<Minutes>> minutes = Arrays.asList(() -> new Minutes(1), () -> new Minutes(2));
        ValueObjectTest.performValueObjectTest(minutes);
    }

    @Test
    public void secondsValueObjectBehavior() {
        final List<Supplier<Seconds>> seconds = Arrays.asList(() -> new Seconds(1), () -> new Seconds(2));
        ValueObjectTest.performValueObjectTest(seconds);
    }

}
