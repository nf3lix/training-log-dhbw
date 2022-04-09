package de.dhbw.training_log.de.report;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.metric.Metric.MetricResult;
import de.dhbw.training_log.de.report.Report.ReportBuilder;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportTest {

    private final Metric metric1 = metricMockWithResult("METRIC_RESULT_1");
    private final Metric metric2 = metricMockWithResult("METRIC_RESULT_2");
    private final Metric metric3 = metricMockWithResult("METRIC_RESULT_3");

    @Test
    public void addMetricsToReport() {
        final ReportBuilder builder = new ReportBuilder();
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(sessionMockWithDistance(new Distance(10.0, KILOMETERS)));
        final Report report = builder.setSessionList(sessionList)
                .addMetric(metric1)
                .addMetric(metric2)
                .addMetric(metric3)
                .build();
        final List<MetricResult> results = report.results();
        assertEquals(results.size(), 3);
        assertEquals(results.get(0).result(), "METRIC_RESULT_1");
        assertEquals(results.get(1).result(), "METRIC_RESULT_2");
        assertEquals(results.get(2).result(), "METRIC_RESULT_3");
    }

    @Test
    public void addMetricsAsCollectionToReport() {
        final ReportBuilder builder = new ReportBuilder();
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(sessionMockWithDistance(new Distance(10.0, KILOMETERS)));
        final List<Metric> metrics = new ArrayList<>();
        metrics.add(metric1);
        metrics.add(metric2);
        metrics.add(metric3);
        final Report report = builder
                .setSessionList(sessionList)
                .addAllMetrics(metrics)
                .build();
        final List<MetricResult> results = report.results();
        assertEquals(results.size(), 3);
        assertEquals(results.get(0).result(), "METRIC_RESULT_1");
        assertEquals(results.get(1).result(), "METRIC_RESULT_2");
        assertEquals(results.get(2).result(), "METRIC_RESULT_3");
    }

    private Session sessionMockWithDistance(final Distance distance) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        return session;
    }

    private Metric metricMockWithResult(final String resultString) {
        final Metric metric = mock(Metric.class);
        final MetricResult result = mock(MetricResult.class);
        when(result.result()).thenReturn(resultString);
        when(metric.compute(anyList())).thenReturn(result);
        return metric;
    }

}
