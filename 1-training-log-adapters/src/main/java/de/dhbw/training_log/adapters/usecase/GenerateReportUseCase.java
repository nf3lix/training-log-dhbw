package de.dhbw.training_log.adapters.usecase;

import de.dhbw.training_log.adapters.mapper.MetricResultMapper;
import de.dhbw.training_log.adapters.resource.MetricResultResource;
import de.dhbw.training_log.application.report.ReportService;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GenerateReportUseCase {

    private final ReportService service;

    public GenerateReportUseCase(final SessionRepository repository) {
        this.service = new ReportService(repository);
    }

    public List<MetricResultResource> getResults() {
        List<Metric.MetricResult> results = service.getResults();
        final MetricResultMapper mapper = new MetricResultMapper();
        return results.stream().map(mapper::toResource).collect(Collectors.toList());
    }

}
