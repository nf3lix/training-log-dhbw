package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.crud_session.CreateSession;
import de.dhbw.training_log.plugins.usecases.crud_session.DeleteSession;
import de.dhbw.training_log.plugins.usecases.filter_sessions.FilterSessionsMenu;
import de.dhbw.training_log.plugins.usecases.generate_report.GenerateReport;
import de.dhbw.training_log.plugins.usecases.crud_session.ReadSession;

public final class MainMenu extends UseCaseMenu {

    public MainMenu(final SessionRepositoryImpl repository) {
        super("Main Menu", true, repository);
        this.addUseCase("1", new CreateSession(repository));
        this.addUseCase("2", new ReadSession(repository));
        this.addUseCase("3", new DeleteSession(repository));
        this.addUseCase("4", new GenerateReport(repository));
        this.addNestedMenu("5", new FilterSessionsMenu(repository));
    }

}
