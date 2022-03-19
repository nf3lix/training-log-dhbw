package dhbw.training_log.de;

import dhbw.training_log.de.training_session_id.SessionId;

import java.util.Iterator;

public interface SessionRepository {

    SessionId nextId();
    Iterator<Session> getAll();
    void insert(final Session trainingSession);

}
