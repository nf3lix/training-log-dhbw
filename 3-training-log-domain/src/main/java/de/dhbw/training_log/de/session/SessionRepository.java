package de.dhbw.training_log.de.session;

import de.dhbw.training_log.de.session.training_session_id.SessionId;

import java.util.Iterator;

public interface SessionRepository {

    SessionId nextId();
    Iterator<Session> getAll();
    void insert(final Session trainingSession);
    void delete(final SessionId sessionId);

}
