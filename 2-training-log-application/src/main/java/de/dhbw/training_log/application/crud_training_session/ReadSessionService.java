package de.dhbw.training_log.application.crud_training_session;

import de.dhbw.training_log.application.Service;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.Iterator;

public abstract class ReadSessionService implements Service {

    private final SessionRepository repository;

    public ReadSessionService(final SessionRepository repository) {
        this.repository = repository;
    }

    public void run() {
        final Iterator<Session> sessions = repository.getAll();
        while(sessions.hasNext()) {
            displaySession(sessions.next());
        }
    }

    protected abstract void displaySession(final Session session);

}
