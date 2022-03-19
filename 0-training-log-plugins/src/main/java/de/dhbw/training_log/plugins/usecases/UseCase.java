package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.plugins.usecases.create_session.CreateSession;
import dhbw.training_log.de.SessionRepository;

import java.util.Optional;

import static java.util.Arrays.stream;

public enum UseCase {

    CREATE_SESSION("1","Create new training session", new CreateSession());

    private final String mnemonic;
    private final String useCaseDescription;
    private final UseCaseInitializer initializer;

    UseCase(final String mnemonic, final String useCaseDescription, final UseCaseInitializer initializer) {
        this.mnemonic = mnemonic;
        this.useCaseDescription = useCaseDescription;
        this.initializer = initializer;
    }

    public String mnemonic() {
        return mnemonic;
    }

    public String description() {
        return useCaseDescription;
    }

    public void initialize(SessionRepository repository) {
        initializer.init(repository);
    }

    public static UseCase fromMnemonic(final String mnemonic) throws IllegalArgumentException {
        final Optional<UseCase> useCase = stream(values()).filter(uc -> uc.mnemonic.equals(mnemonic)).findFirst();
        if(!useCase.isPresent()) {
            throw new IllegalArgumentException("There's no use case for this mnemonic");
        }
        return useCase.get();
    }

}
