package de.dhbw.training_log.application.report.metric_result;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;

public class SessionMetricResult implements Metric.MetricResult {

    private final String metricName;
    private final Session session;

    public SessionMetricResult(String metricName, Session session) {
        this.metricName = metricName;
        this.session = session;
    }

    @Override
    public String name() {
        return metricName;
    }

    @Override
    public Session result() {
        return session;
    }

}
