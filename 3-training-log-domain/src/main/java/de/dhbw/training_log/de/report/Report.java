package de.dhbw.training_log.de.report;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Report {

    private final List<Session> sessionList;
    private final List<Metric> metrics;
    private final List<Metric.MetricResult> results = new ArrayList<>();

    private Report(List<Session> sessionList, List<Metric> metrics) {
        this.sessionList = sessionList;
        this.metrics = metrics;
        generateResults();
    }

    private void generateResults() {
        for(Metric metric : metrics) {
            results.add(metric.compute(sessionList));
        }
    }

    public List<Metric.MetricResult> results() {
        return results;
    }

    public static class ReportBuilder {

        private List<Session> sessionList;
        private final List<Metric> metrics = new ArrayList<>();

        public CreatableReport setSessionList(final List<Session> sessionList) {
            this.sessionList = sessionList;
            return new CreatableReport();
        }

        public class CreatableReport extends ReportBuilder {
            private CreatableReport() { }

            public CreatableReport addMetric(final Metric metric) {
                ReportBuilder.this.metrics.add(metric);
                return this;
            }

            public CreatableReport addAllMetrics(final Collection<Metric> metricList) {
                ReportBuilder.this.metrics.addAll(metricList);
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
