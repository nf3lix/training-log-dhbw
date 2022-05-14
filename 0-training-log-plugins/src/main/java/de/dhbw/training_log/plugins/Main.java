package de.dhbw.training_log.plugins;

import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.MainMenu;

public class Main {

    public static void main(String[] args) {
        final SessionRepositoryImpl repository = new SessionRepositoryImpl();
        final MainMenu menu = new MainMenu(repository);
        menu.start();
    }

}
