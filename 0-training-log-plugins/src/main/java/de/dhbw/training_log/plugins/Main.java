package de.dhbw.training_log.plugins;

import de.dhbw.training_log.plugins.action.MainMenu;
import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.filter_sessions.FilterSessionsMenu;

public class Main {

    private static final SessionRepositoryImpl repository = new SessionRepositoryImpl();
    public static FilterSessionsMenu filterSessionsMenu = new FilterSessionsMenu(repository);
    public static MainMenu mainMenu = new MainMenu(repository);

    public static void main(String[] args) {
        mainMenu.addExitMenuListener(() -> System.exit(0));
        filterSessionsMenu.addExitMenuListener(() -> mainMenu.start());
        mainMenu.start();
    }

}
