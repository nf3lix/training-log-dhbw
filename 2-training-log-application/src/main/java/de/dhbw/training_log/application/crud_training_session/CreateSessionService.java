package de.dhbw.training_log.application.crud_training_session;

import dhbw.training_log.de.Session;
import dhbw.training_log.de.SessionRepository;
import dhbw.training_log.de.description.Description;
import dhbw.training_log.de.distance.Distance;
import dhbw.training_log.de.time.SessionTime;
import dhbw.training_log.de.training_session_type.SessionType;

public abstract class CreateSessionService {

    private final SessionRepository repository;

    public CreateSessionService(final SessionRepository repository) {
        this.repository = repository;
    }

    public final void run() {
        final Distance distance = askForDistance();
        final SessionTime sessionTime = askForSessionTime();
        final SessionType sessionType = askForSessionType();
        final Description description = askForDescription();
        final Session session = new Session(repository.nextId(), distance, sessionTime, description, sessionType);
        createTrainingSession(session);
    }

    private void createTrainingSession(final Session trainingSession) {
        repository.insert(trainingSession);
    }

    protected abstract Distance askForDistance();
    protected abstract SessionTime askForSessionTime();
    protected abstract SessionType askForSessionType();
    protected abstract Description askForDescription();

}
