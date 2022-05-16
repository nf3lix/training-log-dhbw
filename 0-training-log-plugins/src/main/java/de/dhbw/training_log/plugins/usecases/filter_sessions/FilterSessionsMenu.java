package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.UseCase;
import de.dhbw.training_log.plugins.usecases.UseCaseMenu;

public class FilterSessionsMenu extends UseCaseMenu {

    public FilterSessionsMenu(SessionRepositoryImpl repository) {
        super("Filter Sessions", repository);
        addUseCase("1", new UseCase("Filter sessions by distance", new FilterSessionsByDistance(repository)));
        addUseCase("2", new UseCase("Filter sessions by time", new FilterSessionsBySessionTime(repository)));
        addUseCase("3", new UseCase("Filter sessions by date", new FilterSessionsByDate(repository)));
    }

}
