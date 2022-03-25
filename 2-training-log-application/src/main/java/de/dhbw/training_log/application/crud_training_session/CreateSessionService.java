package de.dhbw.training_log.application.crud_training_session;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_type.SessionType;

public abstract class CreateSessionService {

    private final SessionRepository repository;

    public CreateSessionService(final SessionRepository repository) {
        this.repository = repository;
    }

    public final void run() {
        final SessionDate sessionDate = askForSessionDate();
        final Distance distance = askForDistance();
        final SessionTime sessionTime = askForSessionTime();
        final SessionType sessionType = askForSessionType();
        final Description description = askForDescription();
        final Session session = new Session(repository.nextId(), sessionDate, distance, sessionTime, description, sessionType);
        createTrainingSession(session);
    }

    private void createTrainingSession(final Session trainingSession) {
        repository.insert(trainingSession);
    }

    protected abstract Distance askForDistance();
    protected abstract SessionDate askForSessionDate();
    protected abstract Description askForDescription();
    protected abstract SessionTime askForSessionTime();
    protected abstract SessionType askForSessionType();

}
