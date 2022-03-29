package de.dhbw.training_log.de.report;

import de.dhbw.training_log.de.metric.AggregateSubject;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private final List<Session> sessionList;
    private final List<Metric> metrics;

    public Report(List<Session> sessionList, List<Metric> metrics) {
        this.sessionList = sessionList;
        this.metrics = metrics;
    }

    public void compute() {
    }

    public static class ReportBuilder {

        private List<Session> sessionList;
        private final List<Metric> metrics = new ArrayList<>();

        public ReportBuilder() {
        }

        public CreatableReport setSessionList(final List<Session> sessionList) {
            this.sessionList = sessionList;
            return new CreatableReport();
        }

        public class CreatableReport {
            private CreatableReport() { }

            public CreatableReport addMetric(final Metric metric) {
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
