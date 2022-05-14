package de.dhbw.training_log.plugins;

import de.dhbw.training_log.plugins.persistence.CsvFileManipulator;
import de.dhbw.training_log.plugins.persistence.SessionRepositoryImpl;
import de.dhbw.training_log.plugins.usecases.UseCaseCollection;

public class Main {

    public static void main(String[] args) {
        final SessionRepositoryImpl repository = new SessionRepositoryImpl(new CsvFileManipulator());
        printUseCases();
        final String input = CommandLine.readLine();
        UseCaseCollection.fromMnemonic(input).initialize(repository);
    }

    private static void printUseCases() {
        for(final UseCaseCollection useCase : UseCaseCollection.values()) {
            System.out.println(useCase.mnemonic() + ") " + useCase.description());
        }
    }

}
