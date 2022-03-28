package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.session.Session;

public class StandardMetrics {

    public static class TotalSessionsMetric extends Metric<Session, Integer> {
        public TotalSessionsMetric() {
            super(new AggregateFunction.COUNT<>());
        }
    }

}
