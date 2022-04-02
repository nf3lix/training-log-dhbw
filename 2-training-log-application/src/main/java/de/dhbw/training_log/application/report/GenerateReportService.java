package de.dhbw.training_log.application.report;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.report.Report;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.metric.StandardMetrics.*;

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
                .addMetric(new TotalSessionsMetric())
                .addMetric(new MaxDistanceMetric())
                .addMetric(new MinDistanceMetric())
                .addMetric(new AvgDistanceMetric())
                .addMetric(new MaxSessionTimeMetric())
                .addMetric(new MinSessionTimeMetric())
                .addMetric(new AvgSessionTimeMetric())
                .addMetric(new AvgTimePerKilometer())
                .build();
        return report.results();
    }

}
