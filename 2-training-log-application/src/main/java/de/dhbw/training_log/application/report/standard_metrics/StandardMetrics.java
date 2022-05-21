package de.dhbw.training_log.application.report.standard_metrics;

import de.dhbw.training_log.application.report.standard_metrics.BasicSessionMetrics.*;
import de.dhbw.training_log.de.metric.Metric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StandardMetrics {

    TOTAL_SESSIONS(new TotalSessionsMetric()),
    MAX_DISTANCE(new MaxDistanceMetric()),
    MIN_DISTANCE(new MinDistanceMetric()),
    AVG_DISTANCE(new AvgDistanceMetric()),
    MAX_SESSION_TIME(new MaxSessionTimeMetric()),
    MIN_SESSION_TIME(new MinSessionTimeMetric()),
    AVG_SESSION_TIME(new AvgSessionTimeMetric()),
    AVG_TIME_PER_KILOMETER(new AvgTimePerKilometer());

    private final Metric metric;

    StandardMetrics(final Metric metric) {
        this.metric = metric;
    }

    public static List<Metric> all() {
        final List<Metric> metricList = new ArrayList<>();
        Arrays.stream(values()).forEach(standardMetric -> metricList.add(standardMetric.metric));
        return metricList;
    }

}
