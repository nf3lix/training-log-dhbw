package de.dhbw.training_log.application.report.metric_result;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.time.SessionTime;

public class SessionTimeMetricResult implements Metric.MetricResult {

    private final String metricName;
    private final SessionTime sessionTime;

    public SessionTimeMetricResult(String metricName, SessionTime sessionTime) {
        this.metricName = metricName;
        this.sessionTime = sessionTime;
    }

    @Override
    public String name() {
        return metricName;
    }

    @Override
    public SessionTime result() {
        return sessionTime;
    }
}
