package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.crud_session.CreateSessionAction;
import de.dhbw.training_log.plugins.usecases.crud_session.DeleteSessionAction;
import de.dhbw.training_log.plugins.usecases.filter_sessions.FilterSessionsMenuAction;
import de.dhbw.training_log.plugins.usecases.generate_report.GenerateReportAction;
import de.dhbw.training_log.plugins.usecases.crud_session.ReadSessionAction;

public final class MainMenu extends ActionMenu {

    public MainMenu(final SessionRepositoryImpl repository) {
        super("Main Menu", true, repository);
        this.addUseCase("1", new CreateSessionAction(repository));
        this.addUseCase("2", new ReadSessionAction(repository));
        this.addUseCase("3", new DeleteSessionAction(repository));
        this.addUseCase("4", new GenerateReportAction(repository));
        this.addNestedMenu("5", new FilterSessionsMenuAction(repository));
    }

}
