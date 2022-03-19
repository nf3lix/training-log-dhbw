package de.dhbw.training_log.plugins;

import de.dhbw.training_log.plugins.usecases.UseCase;
import dhbw.training_log.de.SessionRepository;

public class Main {

    public static void main(String[] args) {
        final SessionRepository repository = new de.dhbw.training_log.plugins.persistence.SessionRepository();
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
