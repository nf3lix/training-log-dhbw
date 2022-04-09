package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.session.Session;

import java.util.List;

public abstract class Metric {

    public abstract MetricResult compute(final List<Session> list);

    public static class MetricResult {

        private final String name;
        private final Class<?> resultClass;
        private final Object result;

        public MetricResult(final String name, final Object result) {
            this.name = name;
            this.result = result;
            this.resultClass = result.getClass();
        }

        public String name() {
            return name;
        }

        public Class<?> resultClass() {
            return resultClass;
        }

        public Object result() {
            return result;
        }
    }

}
