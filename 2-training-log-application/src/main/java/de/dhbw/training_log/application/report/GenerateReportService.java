package de.dhbw.training_log.application.report;

import de.dhbw.training_log.application.report.standard_metrics.StandardMetrics;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.report.Report;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public class GenerateReportService {

    private final SessionRepository repository;

    public GenerateReportService(final SessionRepository repository) {
        this.repository = repository;
    }

    public List<Metric.MetricResult> generate() {
        final List<Session> sessionList = new ArrayList<>();
        repository.getAll().forEachRemaining(sessionList::add);
        final Report report = new Report.ReportBuilder()
                .setSessionList(sessionList)
                .addAllMetrics(StandardMetrics.all()).build();
        return report.results();
    }

}
