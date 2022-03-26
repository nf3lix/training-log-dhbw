package de.dhbw.training_log.de.session.session_date;

import de.dhbw.training_log.de.test_utils.ValueObjectTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SessionDateTest {

    @Test
    public void getYear() {
        final SessionDate date1 = new SessionDate(new Year(2020), new Month(12), new DayOfMonth(12));
        final SessionDate date2 = new SessionDate(new Year(2021), new Month(12), new DayOfMonth(12));
        final SessionDate date3 = new SessionDate(new Year(2022), new Month(12), new DayOfMonth(12));
        assertEquals(date1.year(), new Year(2020));
        assertEquals(date2.year(), new Year(2021));
        assertEquals(date3.year(), new Year(2022));
    }

    @Test
    public void getMonth() {
        final SessionDate date1 = new SessionDate(new Year(2020), new Month(10), new DayOfMonth(12));
        final SessionDate date2 = new SessionDate(new Year(2021), new Month(11), new DayOfMonth(12));
        final SessionDate date3 = new SessionDate(new Year(2022), new Month(12), new DayOfMonth(12));
        assertEquals(date1.month(), new Month(10));
        assertEquals(date2.month(), new Month(11));
        assertEquals(date3.month(), new Month(12));
    }

    @Test
    public void getDayOfMonth() {
        final SessionDate date1 = new SessionDate(new Year(2020), new Month(10), new DayOfMonth(10));
        final SessionDate date2 = new SessionDate(new Year(2021), new Month(11), new DayOfMonth(11));
        final SessionDate date3 = new SessionDate(new Year(2022), new Month(12), new DayOfMonth(12));
        assertEquals(date1.day(), new DayOfMonth(10));
        assertEquals(date2.day(), new DayOfMonth(11));
        assertEquals(date3.day(), new DayOfMonth(12));
    }

    @Test
    public void invalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> new Month(0));
        assertThrows(IllegalArgumentException.class, () -> new Month(13));
    }

    @Test
    public void invalidDayOfMonth() {
        assertThrows(IllegalArgumentException.class, () -> new DayOfMonth(0));
        assertThrows(IllegalArgumentException.class, () -> new DayOfMonth(32));
    }

    @Test
    public void sessionDateValueObjectBehaviorTest() {
        final List<Supplier<SessionDate>> sessionDates = Arrays.asList(
                () -> new SessionDate(new Year(2020), new Month(12), new DayOfMonth(12)),
                () -> new SessionDate(new Year(2021), new Month(10), new DayOfMonth(10))
        );
        ValueObjectTest.performValueObjectTest(sessionDates);
    }

    @Test
    public void yearValueObjectBehaviorTest() {
        final List<Supplier<Year>> years = Arrays.asList(
                () -> new Year(2018),
                () -> new Year(2019),
                () -> new Year(2020)
        );
        ValueObjectTest.performValueObjectTest(years);
    }

    @Test
    public void monthValueObjectBehaviorTest() {
        final List<Supplier<Month>> months = Arrays.asList(
                () -> new Month(8),
                () -> new Month(9),
                () -> new Month(10)
        );
        ValueObjectTest.performValueObjectTest(months);
    }

    @Test
    public void dayValueObjectBehaviorTest() {
        final List<Supplier<DayOfMonth>> days = Arrays.asList(
                () -> new DayOfMonth(1),
                () -> new DayOfMonth(2),
                () -> new DayOfMonth(3)
        );
        ValueObjectTest.performValueObjectTest(days);
    }

}