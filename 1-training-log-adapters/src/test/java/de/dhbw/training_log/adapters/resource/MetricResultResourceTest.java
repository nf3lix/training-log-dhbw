package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.adapters.mapper.DistanceMapper;
import de.dhbw.training_log.adapters.mapper.SessionDateMapper;
import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.mapper.SessionTimeMapper;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import de.dhbw.training_log.de.session.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MetricResultResourceTest {

    @Test
    public void parseDistanceMetricToString() {
        final Distance result = new Distance(9, KILOMETERS);
        final MetricResultResource resource = new MetricResultResource("METRIC_NAME", result, Distance.class);
        final String distanceString = new DistanceMapper().toResource(result).toString();
        assertEquals(resource.toString(), "METRIC_NAME - " + distanceString);
    }

    @Test
    public void parseSessionDateMetricToString() {
        final SessionDate result = new SessionDate(new Year(2022), new Month(1), new DayOfMonth(1));
        final MetricResultResource resource = new MetricResultResource("METRIC_NAME", result, SessionDate.class);
        final String sessionDateString =  new SessionDateMapper().toResource(result).toString();
        assertEquals(resource.toString(), "METRIC_NAME - " + sessionDateString);
    }

    @Test
    public void parseSessionTimeMetricToString() {
        final SessionTime result = new SessionTime(new Minutes(30), new Seconds(1));
        final MetricResultResource resource = new MetricResultResource("METRIC_NAME", result, SessionTime.class);
        final String sessionTimeString =  new SessionTimeMapper().toResource(result).toString();
        assertEquals(resource.toString(), "METRIC_NAME - " + sessionTimeString);
    }

    @Test
    public void parseSessionMetricToString() {
        final Session result = sessionMock();
        final MetricResultResource resource = new MetricResultResource("METRIC_NAME", result, Session.class);
        final String sessionString =  new SessionEntityMapper().toResource(result).toString();
        assertEquals(resource.toString(), "METRIC_NAME - " + sessionString);
    }

    @Test
    public void parseUnknownMetricTypeToString() {
        final Object result = mock(Object.class);
        when(result.toString()).thenReturn("UNKNOWN_METRIC_TYPE_RESULT");
        final MetricResultResource resource = new MetricResultResource("METRIC_NAME", result, Object.class);
        assertEquals(resource.toString(), "METRIC_NAME - " + result);
    }

    private Session sessionMock() {
        final Session session = mock(Session.class);
        when(session.id()).thenReturn(new SessionId(UUID.fromString("f758cb0b-1122-4e19-8761-c3aaf44c557c")));
        when(session.date()).thenReturn(new SessionDate(new Year(2022), new Month(1), new DayOfMonth(1)));
        when(session.distance()).thenReturn(new Distance(9, KILOMETERS));
        when(session.time()).thenReturn(new SessionTime(new Minutes(30), new Seconds(1)));
        when(session.description()).thenReturn(new Description("DESCRIPTION"));
        when(session.type()).thenReturn(SessionType.OTHER);
        return session;
    }

}
