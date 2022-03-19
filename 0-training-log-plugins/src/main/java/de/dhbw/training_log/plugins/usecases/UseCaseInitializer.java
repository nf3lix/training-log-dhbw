package de.dhbw.training_log.plugins.usecases;

import dhbw.training_log.de.SessionRepository;

abstract class UseCaseInitializer {

    abstract void init(final SessionRepository repository);

}
