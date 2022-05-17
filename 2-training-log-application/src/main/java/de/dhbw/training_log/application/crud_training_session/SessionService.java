package de.dhbw.training_log.application.crud_training_session;

import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;

import java.util.Iterator;
import java.util.List;

public class SessionService {

    private final SessionRepository repository;

    public SessionService(final SessionRepository repository) {
        this.repository = repository;
    }

    public void createSession(final Session session) {
        repository.insert(session);
    }

    public List<Session> getSessions() {
        return repository.getAll();
    }

    public <T extends Comparable<T>> List<Session> getSessions(final FilterCriteria<T> criteria) {
        final List<Session> list = repository.getAll();
        return criteria.apply(list);
    }

    public void deleteSession(final SessionId id) {
        repository.delete(id);
    }

}
