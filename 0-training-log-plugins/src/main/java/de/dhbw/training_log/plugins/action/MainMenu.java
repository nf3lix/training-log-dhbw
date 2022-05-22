package de.dhbw.training_log.plugins.action;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.crud_session.CreateSessionAction;
import de.dhbw.training_log.plugins.usecases.crud_session.DeleteSessionAction;
import de.dhbw.training_log.plugins.usecases.crud_session.ReadSessionAction;
import de.dhbw.training_log.plugins.usecases.filter_sessions.SearchSessionsAction;
import de.dhbw.training_log.plugins.usecases.generate_report.GenerateReportAction;

public final class MainMenu extends ActionMenu {

    public MainMenu(final SessionRepository repository) {
        super("Main Menu", true);
        this.addUseCase("1", new CreateSessionAction(repository));
        this.addUseCase("2", new ReadSessionAction(repository));
        this.addUseCase("3", new DeleteSessionAction(repository));
        this.addUseCase("4", new GenerateReportAction(repository));
        this.addUseCase("5", new SearchSessionsAction(repository));
    }

}
