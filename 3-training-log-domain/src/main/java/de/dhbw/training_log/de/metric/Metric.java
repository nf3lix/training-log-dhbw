package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.session.Session;

import java.util.List;

public abstract class Metric {

    public Metric() {
    }

    public abstract MetricResult compute(final List<Session> list);

    public static class MetricResult {
        private final Class<?> valueClass;
        private final Object value;
        public MetricResult(final Object value) {
            this.valueClass = value.getClass();
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Class<?> getValueClass() {
            return valueClass;
        }
    }

}
