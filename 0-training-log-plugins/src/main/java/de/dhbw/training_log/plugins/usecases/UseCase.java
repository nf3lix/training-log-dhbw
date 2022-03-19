package de.dhbw.training_log.plugins.usecases;

import dhbw.training_log.de.TrainingSessionRepository;

import java.util.Optional;

import static java.util.Arrays.stream;

public enum UseCase {

    CREATE_TRAINING_SESSION("1","Create new training session", new CreateTrainingSession());

    private final String mnemonic;
    private final String useCaseDescription;
    private final UseCaseInitializer initializer;

    UseCase(final String mnemonic, final String useCaseDescription, final UseCaseInitializer initializer) {
        this.mnemonic = mnemonic;
        this.useCaseDescription = useCaseDescription;
        this.initializer = initializer;
    }

    String mnemonic() {
        return mnemonic;
    }

    String description() {
        return useCaseDescription;
    }

    void initialize(TrainingSessionRepository repository) {
        initializer.init(repository);
    }

    static UseCase fromMnemonic(final String mnemonic) throws IllegalArgumentException {
        final Optional<UseCase> useCase = stream(values()).filter(uc -> uc.mnemonic.equals(mnemonic)).findFirst();
        if(!useCase.isPresent()) {
            throw new IllegalArgumentException("There's no use case for this mnemonic");
        }
        return useCase.get();
    }

}
