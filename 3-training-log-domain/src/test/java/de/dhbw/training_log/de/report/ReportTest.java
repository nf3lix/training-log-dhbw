package de.dhbw.training_log.de.report;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportTest {

    @Test
    public void buildReport() {
        final Report.ReportBuilder builder = new Report.ReportBuilder();
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(sessionMockWithDistance(new Distance(10.0, KILOMETERS)));
        final Metric metric = mock(Metric.class);
        final Report report = builder
                .setSessionList(sessionList)
                .addMetric(metric)
                .build();
        assertEquals(report.results().size(), 1);
    }

    private Session sessionMockWithDistance(final Distance distance) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        return session;
    }

}
