package de.dhbw.training_log.plugins;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.action.MainMenu;
import de.dhbw.training_log.plugins.persistence.FileReader;
import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;

public class Main {

    private static final SessionRepository repository = new SessionRepositoryImpl(FileReader.DEFAULT_SESSION_LIST);
    public static MainMenu mainMenu = new MainMenu(repository);

    public static void main(String[] args) {
        mainMenu.addExitMenuListener(() -> System.exit(0));
        mainMenu.start();
    }

}
