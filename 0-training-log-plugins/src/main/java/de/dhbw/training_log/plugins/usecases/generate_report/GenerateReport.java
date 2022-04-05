package de.dhbw.training_log.plugins.usecases.generate_report;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

public class GenerateReport extends UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        final GenerateReportServiceImpl service = new GenerateReportServiceImpl(repository);
        service.run();
    }

}
