package de.dhbw.training_log.application.report.metric_result;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.distance.Distance;

public class DistanceMetricResult implements Metric.MetricResult {

    private final String metricName;
    private final Distance distance;

    public DistanceMetricResult(String metricName, Distance distance) {
        this.metricName = metricName;
        this.distance = distance;
    }

    @Override
    public String name() {
        return metricName;
    }

    @Override
    public Distance result() {
        return distance;
    }

}
