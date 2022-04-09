package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.de.session.SessionRepository;

public abstract class UseCaseInitializer {

    public abstract void init(final SessionRepository repository);

}
