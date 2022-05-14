package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;

public class UseCase {

    private final String description;
    private final UseCaseInitializer initializer;

    public UseCase(final String description, final UseCaseInitializer initializer) {
        this.description = description;
        this.initializer = initializer;
    }

    public String description() {
        return description;
    }

    public void initialize(final SessionRepository repository) {
        initializer.init(repository);
    }

}
