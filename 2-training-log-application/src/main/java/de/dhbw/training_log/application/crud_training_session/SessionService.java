package de.dhbw.training_log.application.crud_training_session;

import dhbw.training_log.de.Session;
import dhbw.training_log.de.SessionRepository;

public class SessionService {

    private final SessionRepository repository;

    public SessionService(final SessionRepository repository) {
        this.repository = repository;
    }

    public void createTrainingSession(final Session trainingSession) {
        repository.insert(trainingSession);
    }

}
