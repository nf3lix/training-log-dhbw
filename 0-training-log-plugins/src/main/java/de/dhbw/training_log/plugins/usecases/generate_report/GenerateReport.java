package de.dhbw.training_log.plugins.usecases.generate_report;

import de.dhbw.training_log.adapters.mapper.MetricResultMapper;
import de.dhbw.training_log.application.report.GenerateReportService;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

import java.util.List;

public class GenerateReport implements UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        new GenerateReportServiceImpl(repository).run();
    }

    private static class GenerateReportServiceImpl extends GenerateReportService {

        public GenerateReportServiceImpl(SessionRepository repository) {
            super(repository);
        }

        @Override
        protected void displayResults(List<Metric.MetricResult> metricResults) {
            for(Metric.MetricResult result : metricResults) {
                System.out.println(new MetricResultMapper().toResource(result).toString());
            }
        }
    }

}
