package de.dhbw.training_log.de.time;

import de.dhbw.training_log.de.test_utils.ValueObjectTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static de.dhbw.training_log.de.time.SessionTimeMatcher.hasTime;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SessionTimeTest {

    @Test
    @DisplayName("Throw exception when amount of seconds is negative")
    public void throwExceptionWhenSecondsIsNegative() {
        assertThrows(IllegalStateException.class, () -> new Seconds(-1));
    }

    @Test
    @DisplayName("Throw exception when amount of minutes is negative")
    public void throwExceptionWhenMinutesIsNegative() {
        assertThrows(IllegalStateException.class, () -> new Minutes(-1));
    }

    @Test
    @DisplayName("Assign minutes and seconds to SessionTime by constructor")
    public void assignMinutesAndSecondsToSessionTime() {
        for(int minutes = 0; minutes < 6; minutes++) {
            final Integer seconds = 10 * minutes;
            final SessionTime sessionTime = new SessionTime(new Minutes(minutes), new Seconds(seconds));
            assertThat(sessionTime, hasTime(minutes, seconds));
        }
    }

    @Test
    @DisplayName("60 Seconds are converted to one minute")
    public void rebalanceSecondsOfSessionTime() {
        final SessionTime sessionTime = new SessionTime(new Minutes(1), new Seconds(61));
        assertThat(sessionTime, hasTime(2, 1));
    }

    @Test
    @DisplayName("Add time to SessionTime object")
    public void addSessionTimes() {
        final SessionTime sessionTime1 = new SessionTime(new Minutes(2), new Seconds(20));
        final SessionTime sessionTime2 = new SessionTime(new Minutes(3), new Seconds(20));
        final SessionTime sessionTime3 = new SessionTime(new Minutes(4), new Seconds(40));
        assertThat(sessionTime1.add(sessionTime2), hasTime(5, 40));
        assertThat(sessionTime1.add(sessionTime3), hasTime(7, 0));
    }

    @Test
    @DisplayName("Correct Value Object behavior of class SessionTime")
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
    @DisplayName("Correct Value Object behavior of class Minutes")
    public void minutesValueObjectBehavior() {
        final List<Supplier<Minutes>> minutes = Arrays.asList(() -> new Minutes(1), () -> new Minutes(2));
        ValueObjectTest.performValueObjectTest(minutes);
    }

    @Test
    @DisplayName("Correct Value Object behavior of class Seconds")
    public void secondsValueObjectBehavior() {
        final List<Supplier<Seconds>> seconds = Arrays.asList(() -> new Seconds(1), () -> new Seconds(2));
        ValueObjectTest.performValueObjectTest(seconds);
    }

}
