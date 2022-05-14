package de.dhbw.training_log.plugins.persistence;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

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
    public Iterator<Session> getAll() {
        return sessionsList.listIterator();
    }

    @Override
    public void insert(final Session session) {
        sessionsList.add(session);
    }

}
