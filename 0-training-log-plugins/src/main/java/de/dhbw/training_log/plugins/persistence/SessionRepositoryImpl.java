package de.dhbw.training_log.plugins.persistence;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;

import java.util.*;

public class SessionRepositoryImpl implements SessionRepository {

    private final List<Session> sessionsList = new ArrayList<>();

    /**
     * Construct SessionRepository with some dummy items
     */
    public SessionRepositoryImpl() {
        sessionsList.addAll(FileReader.DEFAULT_SESSION_LIST);
    }

    @Override
    public SessionId nextId() {
        return new SessionId(UUID.randomUUID());
    }

    @Override
    public List<Session> getAll() {
        return sessionsList;
    }

    @Override
    public void insert(final Session session) {
        sessionsList.add(session);
    }

    @Override
    public void delete(SessionId sessionId) {
        final Session session = findById(sessionId);
        sessionsList.remove(session);
    }

    private Session findById(SessionId sessionId) {
        final Optional<Session> result = sessionsList.stream().filter(session -> session.id().equals(sessionId)).findFirst();
        if(result.isPresent()) {
            return result.get();
        }
        throw new NoSuchElementException();
    }

}
