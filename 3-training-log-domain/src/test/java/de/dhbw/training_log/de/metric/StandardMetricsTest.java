package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.metric.StandardMetrics.*;
import static de.dhbw.training_log.de.session.distance.DistanceUnit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StandardMetricsTest {

    @Test
    public void computeTotalSessionsMetric() {
        final TotalSessionsMetric metric = new TotalSessionsMetric();
        final List<Session> sessionList = new ArrayList<>();
        for(int listCount = 0; listCount <= 5; listCount++) {
            final Metric.MetricResult result = metric.compute(sessionList);
            assertEquals(result.getValue(), listCount);
            sessionList.add(mock(Session.class));

        }
    }

    @Test
    public void computeMinMaxDistanceMetric() {
        final MaxDistanceMetric maxMetric = new MaxDistanceMetric();
        final MinDistanceMetric minMetric = new MinDistanceMetric();
        final List<Session> sessions = new ArrayList<>();
        sessions.add(sessionMockWithDistance(new Distance(900.0, METERS)));
        sessions.add(sessionMockWithDistance(new Distance(800.0, METERS)));
        sessions.add(sessionMockWithDistance(new Distance(1.0, MILES)));
        sessions.add(sessionMockWithDistance(new Distance(1.0, KILOMETERS)));
        final Session maxResult = ((Session) maxMetric.compute(sessions).getValue());
        final Session minResult = ((Session) minMetric.compute(sessions).getValue());
        assertEquals(maxResult.distance(), new Distance(1.0, MILES));
        assertEquals(minResult.distance(), new Distance(800.0, METERS));
    }

    @Test
    public void computeAvgDistanceMetric() {
        final AvgDistanceMetric avgDistanceMetric = new AvgDistanceMetric();
        final List<Session> sessions = new ArrayList<>();
        sessions.add(sessionMockWithDistance(new Distance(1.0, KILOMETERS)));
        sessions.add(sessionMockWithDistance(new Distance(3.0, KILOMETERS)));
        sessions.add(sessionMockWithDistance(new Distance(5.0, KILOMETERS)));
        assertEquals(avgDistanceMetric.compute(sessions).getValue(), new Distance(3.0, KILOMETERS));
    }

    @Test
    public void computeMinMaxSessionTimeMetric() {
        final MinSessionTimeMetric minMetric = new MinSessionTimeMetric();
        final MaxSessionTimeMetric maxMetric = new MaxSessionTimeMetric();
        final List<Session> sessions = new ArrayList<>();
        sessions.add(sessionMockWithTime(new SessionTime(new Minutes(1), new Seconds(40))));
        sessions.add(sessionMockWithTime(new SessionTime(new Minutes(1), new Seconds(20))));
        sessions.add(sessionMockWithTime(new SessionTime(new Minutes(2), new Seconds(0))));
        sessions.add(sessionMockWithTime(new SessionTime(new Minutes(1), new Seconds(50))));
        final Session minResult = (Session) minMetric.compute(sessions).getValue();
        final Session maxResult = (Session) maxMetric.compute(sessions).getValue();
        assertEquals(minResult.time(), new SessionTime(new Minutes(1), new Seconds(20)));
        assertEquals(maxResult.time(), new SessionTime(new Minutes(2), new Seconds(0)));
    }

    @Test
    public void computeAvgSessionTimeMetric() {
        final AvgSessionTimeMetric avgSessionTimeMetric = new AvgSessionTimeMetric();
        final List<Session> sessions = new ArrayList<>();
        sessions.add(sessionMockWithTime(new SessionTime(new Minutes(1), new Seconds(40))));
        sessions.add(sessionMockWithTime(new SessionTime(new Minutes(1), new Seconds(20))));
        sessions.add(sessionMockWithTime(new SessionTime(new Minutes(6), new Seconds(0))));
        assertEquals(avgSessionTimeMetric.compute(sessions).getValue(), new SessionTime(new Minutes(3), new Seconds(0)));
    }

    @Test
    public void computeTimePerKilometer() {
        final Session session = sessionMock(new Distance(10.0, KILOMETERS), new SessionTime(new Minutes(52), new Seconds(0)));
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(session);
        final SessionTime pace = (SessionTime) new AvgTimePerKilometer().compute(sessionList).getValue();
        assertEquals(pace, new SessionTime(new Minutes(5), new Seconds(12)));
    }

    private Session sessionMock(final Distance distance, final SessionTime sessionTime) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        when(session.time()).thenReturn(sessionTime);
        return session;
    }

    private Session sessionMockWithDistance(final Distance distance) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        return session;
    }

    private Session sessionMockWithTime(final SessionTime sessionTime) {
        final Session session = mock(Session.class);
        when(session.time()).thenReturn(sessionTime);
        return session;
    }

}
