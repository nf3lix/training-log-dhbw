package de.dhbw.training_log.plugins.usecases.generate_report;

import de.dhbw.training_log.adapters.usecase.GenerateReportUseCase;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.UserAction;

public class GenerateReportAction implements UserAction {

    private final GenerateReportUseCase service;

    public GenerateReportAction(final SessionRepository repository) {
        this.service = new GenerateReportUseCase(repository);
    }

    @Override
    public void initialize() {
        service.getResults().forEach(System.out::println);
    }

    @Override
    public String getDescription() {
        return "Generate Report";
    }
}
