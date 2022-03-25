package de.dhbw.training_log.de;

import de.dhbw.training_log.de.description.Description;
import de.dhbw.training_log.de.distance.Distance;
import de.dhbw.training_log.de.session_date.SessionDate;
import de.dhbw.training_log.de.time.SessionTime;
import de.dhbw.training_log.de.training_session_id.SessionId;
import de.dhbw.training_log.de.training_session_type.SessionType;

public class Session {

    private final SessionId id;
    private final SessionDate date;
    private Distance distance;
    private SessionTime time;
    private Description description;
    private SessionType type;

    public Session(final SessionId id, final SessionDate date, final Distance distance, final SessionTime time,
                   final Description description, final SessionType type) {
        this.id = id;
        this.date = date;
        this.distance = distance;
        this.time = time;
        this.description = description;
        this.type = type;
    }

    public SessionId id() {
        return id;
    }

    public SessionDate date() {
        return date;
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
