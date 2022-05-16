package de.dhbw.training_log.plugins.usecases.generate_report;

import de.dhbw.training_log.adapters.mapper.MetricResultMapper;
import de.dhbw.training_log.application.report.GenerateReportService;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;

import java.util.List;

public class GenerateReport extends GenerateReportService {

    public GenerateReport(SessionRepositoryImpl repository) {
        super(repository);
    }

    @Override
    protected void displayResults(List<Metric.MetricResult> metricResults) {
        for(Metric.MetricResult result : metricResults) {
            System.out.println(new MetricResultMapper().toResource(result).toString());
        }
    }

}
