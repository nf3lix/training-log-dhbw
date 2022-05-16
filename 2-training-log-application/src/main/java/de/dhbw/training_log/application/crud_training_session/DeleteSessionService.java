package de.dhbw.training_log.application.crud_training_session;

import de.dhbw.training_log.application.Service;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;

public abstract class DeleteSessionService implements Service {

    private final SessionRepository repository;

    public DeleteSessionService(final SessionRepository repository) {
        this.repository = repository;
    }

    public void run() {
        final SessionId id = askForSessionId();
        repository.delete(id);
    }

    abstract SessionId askForSessionId();

}
