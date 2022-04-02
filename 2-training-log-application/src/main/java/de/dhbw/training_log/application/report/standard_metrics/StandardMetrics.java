package de.dhbw.training_log.application.report.standard_metrics;

import de.dhbw.training_log.application.report.standard_metrics.BasicSessionMetrics.*;
import de.dhbw.training_log.de.metric.Metric;

public enum StandardMetrics {

    TOTAL_SESSIONS {
        @Override
        public Metric metric() {
            return new TotalSessionsMetric();
        }
    },

    MAX_DISTANCE {
        @Override
        public Metric metric() {
            return new MaxDistanceMetric();
        }
    },

    MIN_DISTANCE {
        @Override
        public Metric metric() {
            return new MinDistanceMetric();
        }
    },

    AVG_DISTANCE {
        @Override
        public Metric metric() {
            return new AvgDistanceMetric();
        }
    },

    MAX_SESSION_TIME {
        @Override
        public Metric metric() {
            return new MaxSessionTimeMetric();
        }
    },

    MIN_SESSION_TIME {
        @Override
        public Metric metric() {
            return new MinSessionTimeMetric();
        }
    },

    AVG_SESSION_TIME {
        @Override
        public Metric metric() {
            return new AvgSessionTimeMetric();
        }
    },

    AVG_TIME_PER_KILOMETER {
        @Override
        public Metric metric() {
            return new AvgTimePerKilometer();
        }
    };

    public abstract Metric metric();

}
