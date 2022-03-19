package de.dhbw.training_log.plugins;

import de.dhbw.training_log.plugins.persistence.CsvFileManipulator;
import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.UseCase;

public class Main {

    public static void main(String[] args) {
        final SessionRepositoryImpl repository = new SessionRepositoryImpl(new CsvFileManipulator());
        printUseCases();
        final String input = CommandLine.readLine();
        UseCase.fromMnemonic(input).initialize(repository);
    }

    private static void printUseCases() {
        for(final UseCase useCase : UseCase.values()) {
            System.out.println(useCase.mnemonic() + ") " + useCase.description());
        }
    }

}