package de.dhbw.training_log.de.report;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private final List<Session> sessionList;
    private final List<Metric<Session, Object>> metrics;

    public Report(List<Session> sessionList, List<Metric<Session, Object>> metrics) {
        this.sessionList = sessionList;
        this.metrics = metrics;
    }

    public void compute() {
        metrics.get(0).compute(sessionList);
    }

    public static class ReportBuilder {

        private List<Session> sessionList;
        private final List<Metric<Session, Object>> metrics = new ArrayList<>();

        public ReportBuilder(List<Session> sessionList) {
            this.sessionList = sessionList;
        }

        public CreatableReport setSessionList(final List<Session> sessionList) {
            this.sessionList = sessionList;
            return new CreatableReport();
        }

        public class CreatableReport {
            private CreatableReport() { }

            public CreatableReport addMetric(final Metric<Session, Object> metric) {
                ReportBuilder.this.metrics.add(metric);
                return this;
            }

            public Report build() {
                return ReportBuilder.this.build();
            }
        }

        private Report build() {
            return new Report(this.sessionList, this.metrics);
        }

    }

}
