package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.metric.StandardMetrics.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StandardMetricsTest {

    @Test
    public void computeTimePerKilometer() {
        final Session session = sessionMock(
                new Distance(10.0, DistanceUnit.KILOMETERS),
                new SessionTime(new Minutes(52), new Seconds(0))
        );
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(session);
        final SessionTime pace = new AvgTimePerKilometer().compute(sessionList);
        Assertions.assertEquals(pace, new SessionTime(new Minutes(5), new Seconds(12)));
    }

    private Session sessionMock(final Distance distance, final SessionTime sessionTime) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        when(session.time()).thenReturn(sessionTime);
        return session;
    }

}
