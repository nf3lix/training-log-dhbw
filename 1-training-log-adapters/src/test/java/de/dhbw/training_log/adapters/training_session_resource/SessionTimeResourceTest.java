package de.dhbw.training_log.adapters.training_session_resource;

import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SessionTimeResourceTest {

    @Test
    public void throwExceptionWhenStringInputHasNoValidFormat() {
        assertThrows(IllegalArgumentException.class, () -> new SessionTimeResource("TEST"));
        assertThrows(IllegalArgumentException.class, () -> new SessionTimeResource("TEST:"));
        assertThrows(IllegalArgumentException.class, () -> new SessionTimeResource("TEST:TEST:"));
        assertThrows(IllegalArgumentException.class, () -> new SessionTimeResource("TEST:TEST:TEST"));
    }

    @Test
    public void throwExceptionWhenSegmentsCannotBeParsedToString() {
        assertThrows(NumberFormatException.class, () -> new SessionTimeResource("TEST:TEST"));
        assertThrows(NumberFormatException.class, () -> new SessionTimeResource("1T:1T"));
    }

    @Test
    public void throwExceptionWhenSecondsAreGreaterThan59() {
        assertThrows(NumberFormatException.class, () -> new SessionTimeResource("1:60"));
        assertThrows(NumberFormatException.class, () -> new SessionTimeResource("2:61"));
    }

    @Test
    public void assignMinutes() {
        final SessionTimeResource t1 = new SessionTimeResource("1:00");
        final SessionTimeResource t2 = new SessionTimeResource("2:00");
        final SessionTimeResource t3 = new SessionTimeResource("10:00");
        assertEquals(1, t1.minutes());
        assertEquals(2, t2.minutes());
        assertEquals(10, t3.minutes());
    }

    @Test
    public void assignSeconds() {
        final SessionTimeResource t1 = new SessionTimeResource("0:10");
        final SessionTimeResource t2 = new SessionTimeResource("0:30");
        final SessionTimeResource t3 = new SessionTimeResource("0:59");
        assertEquals(10, t1.seconds());
        assertEquals(30, t2.seconds());
        assertEquals(59, t3.seconds());
    }

    @Test
    public void displayText() {
        final SessionTimeResource t1 = new SessionTimeResource("0:10");
        final SessionTimeResource t2 = new SessionTimeResource("2:00");
        final SessionTimeResource t3 = new SessionTimeResource("10:59");
        assertEquals(t1.toString(), "0:10");
        assertEquals(t2.toString(), "2:00");
        assertEquals(t3.toString(), "10:59");
    }

}
