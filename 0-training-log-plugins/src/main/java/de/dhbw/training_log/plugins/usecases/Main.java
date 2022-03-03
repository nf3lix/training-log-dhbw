package de.dhbw.training_log.plugins.usecases;

public class Main {

    public static void main(String[] args) {
        printUseCases();
        final String input = CommandLine.readLine();
        UseCase.fromMnemonic(input).initialize();
    }

    private static void printUseCases() {
        for(final UseCase useCase : UseCase.values()) {
            System.out.println(useCase.mnemonic() + ") " + useCase.description());
        }
    }

}
