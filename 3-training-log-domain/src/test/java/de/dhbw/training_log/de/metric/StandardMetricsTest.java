package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.session.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.metric.StandardMetrics.TotalSessionsMetric;
import static org.mockito.Mockito.mock;

public class StandardMetricsTest {

    @Test
    public void totalSessionMetric() {
        final TotalSessionsMetric metric = new TotalSessionsMetric();
        final List<Session> sessions = new ArrayList<>();
        sessions.add(mock(Session.class));
        sessions.add(mock(Session.class));
        sessions.add(mock(Session.class));
        Assertions.assertEquals(metric.compute(sessions), 3);
    }

}
