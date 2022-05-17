package de.dhbw.training_log.application.report;

import de.dhbw.training_log.application.Service;
import de.dhbw.training_log.application.report.standard_metrics.StandardMetrics;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.report.Report;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class GenerateReportService implements Service {

    private final SessionRepository repository;

    public GenerateReportService(final SessionRepository repository) {
        this.repository = repository;
    }

    public void run() {
        List<Metric.MetricResult> results = generateResults();
        displayResults(results);
    }

    private List<Metric.MetricResult> generateResults() {
        final List<Session> sessionList = repository.getAll();
        final Report report = new Report.ReportBuilder()
                .setSessionList(sessionList)
                .addAllMetrics(StandardMetrics.all()).build();
        return report.results();
    }

    protected abstract void displayResults(final List<Metric.MetricResult> metricResults);

}
