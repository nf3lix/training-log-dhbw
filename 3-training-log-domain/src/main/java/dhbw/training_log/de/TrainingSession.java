package dhbw.training_log.de;

import dhbw.training_log.de.description.Description;
import dhbw.training_log.de.distance.Distance;
import dhbw.training_log.de.time.SessionTime;
import dhbw.training_log.de.training_session_id.TrainingSessionId;
import dhbw.training_log.de.training_session_type.TrainingSessionType;

public class TrainingSession {

    private final TrainingSessionId id;
    private Distance distance;
    private SessionTime time;
    private Description description;
    private TrainingSessionType type;

    public TrainingSession(final TrainingSessionId id, final Distance distance, final SessionTime time,
                           final Description description, final TrainingSessionType type) {
        this.id = id;
        this.distance = distance;
        this.time = time;
        this.description = description;
        this.type = type;
    }

    public TrainingSessionId id() {
        return id;
    }

    public Distance distance() {
        return distance;
    }

    public SessionTime time() {
        return time;
    }

    public Description description() {
        return description;
    }

    public TrainingSessionType type() {
        return type;
    }
}
