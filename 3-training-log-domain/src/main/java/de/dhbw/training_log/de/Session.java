package de.dhbw.training_log.de;

import de.dhbw.training_log.de.description.Description;
import de.dhbw.training_log.de.distance.Distance;
import de.dhbw.training_log.de.time.SessionTime;
import de.dhbw.training_log.de.training_session_id.SessionId;
import de.dhbw.training_log.de.training_session_type.SessionType;

public class Session {

    private final SessionId id;
    private Distance distance;
    private SessionTime time;
    private Description description;
    private SessionType type;

    public Session(final SessionId id, final Distance distance, final SessionTime time,
                   final Description description, final SessionType type) {
        this.id = id;
        this.distance = distance;
        this.time = time;
        this.description = description;
        this.type = type;
    }

    public SessionId id() {
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

    public SessionType type() {
        return type;
    }
}
