package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.MainMenu;
import de.dhbw.training_log.plugins.usecases.UseCase;
import de.dhbw.training_log.plugins.usecases.UseCaseMenu;

public class FilterSessionsMenu extends UseCaseMenu {

    public FilterSessionsMenu(SessionRepository repository) {
        super("Filter Sessions", repository);
        addUseCase("1", new UseCase("Filter sessions by distance", new FilterSessionsByDistance()));
        addUseCase("2", new UseCase("Filter sessions by time", new FilterSessionsBySessionTime()));
        addUseCase("3", new UseCase("Filter sessions by date", new FilterSessionsByDate()));
    }

}
