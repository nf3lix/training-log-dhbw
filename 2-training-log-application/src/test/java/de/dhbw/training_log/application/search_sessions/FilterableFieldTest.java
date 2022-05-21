package de.dhbw.training_log.application.search_sessions;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.application.search_sessions.FilterableField.*;
import static de.dhbw.training_log.de.session.distance.DistanceUnit.*;
import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterableFieldTest {

    @Test
    public void getDistanceInMeters() {
        assertEquals(DISTANCE.mapper().apply(sessionWithDistance(10, KILOMETERS)), 10000.0);
        assertEquals(DISTANCE.mapper().apply(sessionWithDistance(10, METERS)), 10);
        assertEquals(DISTANCE.mapper().apply(sessionWithDistance(10, MILES)), 16093.44);
    }

    @Test
    public void getSessionTimeInSeconds() {
        assertEquals(SESSION_TIME.mapper().apply(sessionWithTime(new SessionTime(new Minutes(10), new Seconds(1)))), 601);
    }

    @Test
    public void getSessionDateAsTimestamp() {
        final SessionDate sessionDate = new SessionDate(new Year(2022), new Month(1), new DayOfMonth(1));
        assertEquals(SESSION_DATE.mapper().apply(sessionWithDate(sessionDate)), 1640991600000.0);
    }

    @Test
    public void getSessionTypeAsOrdinal() {
        for(final SessionType type : SessionType.values()) {
            assertEquals(SESSION_TYPE.mapper().apply(sessionWithType(type)), type.ordinal());
        }
    }

    private Session sessionWithDistance(final double distance, final DistanceUnit unit) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(new Distance(distance, unit));
        return session;
    }

    private Session sessionWithTime(final SessionTime sessionTime) {
        final Session session = mock(Session.class);
        when(session.time()).thenReturn(sessionTime);
        return session;
    }

    private Session sessionWithDate(final SessionDate sessionDate) {
        final Session session = mock(Session.class);
        when(session.date()).thenReturn(sessionDate);
        return session;
    }

    private Session sessionWithType(final SessionType type) {
        final Session session = mock(Session.class);
        when(session.type()).thenReturn(type);
        return session;
    }

}
