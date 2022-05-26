package de.dhbw.training_log.application.report;

import de.dhbw.training_log.application.report.standard_metrics.StandardMetrics;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.List;

public class ReportService {

    private final SessionRepository repository;

    public ReportService(final SessionRepository repository) {
        this.repository = repository;
    }

    public List<Metric.MetricResult> getResults() {
        final List<Session> sessionList = repository.getAll();
        final Report report = getReport(sessionList);
        return report.results();
    }

    private Report getReport(final List<Session> sessions) {
        return new Report.ReportBuilder()
                .setSessionList(sessions)
                .addAllMetrics(StandardMetrics.all())
                .build();
    }

}
