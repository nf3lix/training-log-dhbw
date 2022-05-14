package de.dhbw.training_log.plugins;

import de.dhbw.training_log.plugins.persistence.CsvFileManipulator;
import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.MainMenu;
import de.dhbw.training_log.plugins.usecases.UseCaseCollection;

public class Main {

    public static void main(String[] args) {
        final SessionRepositoryImpl repository = new SessionRepositoryImpl(new CsvFileManipulator());
        final MainMenu menu = new MainMenu(repository);
        menu.printUseCases();
        final String input = CommandLine.readLine();
        menu.initUseCase(input);
    }

}
