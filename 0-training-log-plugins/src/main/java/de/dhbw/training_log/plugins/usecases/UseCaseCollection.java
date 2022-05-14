package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;

import java.util.HashMap;
import java.util.Map;

public class UseCaseCollection {

    private final Map<String, UseCase> useCases = new HashMap<>();
    private final SessionRepository repository;

    public UseCaseCollection(final SessionRepository repository) {
        this.repository = repository;
    }

    public void addUseCase(final String mnemonic, final UseCase useCase) {
        this.useCases.put(mnemonic, useCase);
    }

    public void initUseCase(final String mnemonic) {
        final UseCase useCase = this.useCases.get(mnemonic);
        if(useCase == null) {
            throw new IllegalArgumentException("There's no use case for this mnemonic");
        }
        useCase.initialize(repository);
    }

    public void printUseCases() {
        this.useCases.forEach((mnemonic, useCase) ->
                System.out.println(mnemonic + ") " + useCase.description())
        );
    }

}
