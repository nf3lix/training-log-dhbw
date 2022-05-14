package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.create_session.CreateSession;
import de.dhbw.training_log.plugins.usecases.filter_sessions.FilterSessionsMenu;
import de.dhbw.training_log.plugins.usecases.generate_report.GenerateReport;
import de.dhbw.training_log.plugins.usecases.read_session.ReadSession;

public final class MainMenu extends UseCaseMenu {

    public MainMenu(final SessionRepository repository) {
        super("Main Menu", true, repository);
        this.addUseCase("1", new UseCase("Create new training session", new CreateSession(repository)));
        this.addUseCase("2", new UseCase("Show all training sessions", new ReadSession(repository)));
        this.addUseCase("3", new UseCase("Generate Report", new GenerateReport(repository)));
        this.addNestedMenu("4", new FilterSessionsMenu(repository));
    }

}
