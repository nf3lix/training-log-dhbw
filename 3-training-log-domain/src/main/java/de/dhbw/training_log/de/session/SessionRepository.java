package de.dhbw.training_log.de.session;

import de.dhbw.training_log.de.session.training_session_id.SessionId;

import java.util.Iterator;
import java.util.List;

public interface SessionRepository {

    SessionId nextId();
    List<Session> getAll();
    void insert(final Session trainingSession);
    void delete(final SessionId sessionId);

}
