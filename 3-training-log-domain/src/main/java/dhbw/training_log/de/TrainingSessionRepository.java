package dhbw.training_log.de;

import dhbw.training_log.de.training_session_id.TrainingSessionId;

import java.util.Iterator;

public interface TrainingSessionRepository {

    TrainingSessionId nextId();
    Iterator<TrainingSession> getAll();
    void insert(final TrainingSession trainingSession);

}
