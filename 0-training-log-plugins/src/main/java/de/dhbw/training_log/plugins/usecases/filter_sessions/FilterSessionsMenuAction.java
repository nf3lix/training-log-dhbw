package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.UseCaseMenu;

public class FilterSessionsMenuAction extends UseCaseMenu {

    public FilterSessionsMenuAction(SessionRepositoryImpl repository) {
        super("Filter Sessions", repository);
        addUseCase("1", new FilterSessionsByDistanceAction(repository));
        addUseCase("2", new FilterSessionsBySessionTimeAction(repository));
        addUseCase("3", new FilterSessionsByDateAction(repository));
    }

}
