package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;

public class UseCase {

    private String mnemonic;
    private String description;
    private UseCaseInitializer initializer;

    public UseCase(final String mnemonic, final String description, final UseCaseInitializer initializer) {
        this.mnemonic = mnemonic;
        this.description = description;
        this.initializer = initializer;
    }

    public boolean mnemonicEquals(final String input) {
        return input.equalsIgnoreCase(mnemonic);
    }

    public String description() {
        return description;
    }

    public void initialize(final SessionRepository repository) {
        initializer.init(repository);
    }

}
