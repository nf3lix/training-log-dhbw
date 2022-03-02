package de.dhbw.training_log.application.crud_training_session;

import dhbw.training_log.de.TrainingSession;
import dhbw.training_log.de.TrainingSessionRepository;

public class TrainingSessionService {

    private final TrainingSessionRepository repository;

    public TrainingSessionService(final TrainingSessionRepository repository) {
        this.repository = repository;
    }

    public void createTrainingSession(final TrainingSession trainingSession) {
        repository.insert(trainingSession);
    }

}
