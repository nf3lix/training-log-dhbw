package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.create_session.CreateSession;
import de.dhbw.training_log.plugins.usecases.filter_sessions.FilterSessions;
import de.dhbw.training_log.plugins.usecases.generate_report.GenerateReport;
import de.dhbw.training_log.plugins.usecases.read_session.ReadSession;

public final class MainMenu extends UseCaseCollection {

    public MainMenu(final SessionRepository repository) {
        super(repository);
        this.addUseCase("1", new UseCase("Create new training session", new CreateSession()));
        this.addUseCase("2", new UseCase("Show all training sessions", new ReadSession()));
        this.addUseCase("3", new UseCase("Generate Report", new GenerateReport()));
        this.addUseCase("4", new UseCase("Filter Sessions", new FilterSessions()));
    }

}
