package de.dhbw.training_log.plugins.usecases;

import dhbw.training_log.de.TrainingSessionRepository;

public class Main {

    public static void main(String[] args) {
        final TrainingSessionRepository repository = new SessionRepository();
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
