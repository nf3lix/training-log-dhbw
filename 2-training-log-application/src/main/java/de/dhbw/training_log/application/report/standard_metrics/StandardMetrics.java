package de.dhbw.training_log.application.report.standard_metrics;

import de.dhbw.training_log.application.report.standard_metrics.BasicSessionMetrics.*;
import de.dhbw.training_log.de.metric.Metric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StandardMetrics {

    TOTAL_SESSIONS {
        @Override
        Metric metric() {
            return new TotalSessionsMetric();
        }
    },

    MAX_DISTANCE {
        @Override
        Metric metric() {
            return new MaxDistanceMetric();
        }
    },

    MIN_DISTANCE {
        @Override
        Metric metric() {
            return new MinDistanceMetric();
        }
    },

    AVG_DISTANCE {
        @Override
        Metric metric() {
            return new AvgDistanceMetric();
        }
    },

    MAX_SESSION_TIME {
        @Override
        Metric metric() {
            return new MaxSessionTimeMetric();
        }
    },

    MIN_SESSION_TIME {
        @Override
        Metric metric() {
            return new MinSessionTimeMetric();
        }
    },

    AVG_SESSION_TIME {
        @Override
        Metric metric() {
            return new AvgSessionTimeMetric();
        }
    },

    AVG_TIME_PER_KILOMETER {
        @Override
        Metric metric() {
            return new AvgTimePerKilometer();
        }
    };

    abstract Metric metric();

    public static List<Metric> all() {
        final List<Metric> metricList = new ArrayList<>();
        Arrays.stream(values()).forEach(standardMetric -> metricList.add(standardMetric.metric()));
        return metricList;
    }

}
