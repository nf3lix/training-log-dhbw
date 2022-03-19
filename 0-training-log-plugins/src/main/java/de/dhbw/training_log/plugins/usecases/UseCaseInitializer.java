package de.dhbw.training_log.plugins.usecases;

import dhbw.training_log.de.SessionRepository;

public abstract class UseCaseInitializer {

    public abstract void init(final SessionRepository repository);

}
