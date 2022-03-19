package de.dhbw.training_log.plugins.usecases;

import dhbw.training_log.de.TrainingSessionRepository;

abstract class UseCaseInitializer {

    abstract void init(final TrainingSessionRepository repository);

}
