package de.dhbw.training_log.de.session;

import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import de.dhbw.training_log.de.session.training_session_type.SessionType;

public class Session {

    private final SessionId id;
    private SessionDate date;
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

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public void setTime(SessionTime time) {
        this.time = time;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setType(SessionType type) {
        this.type = type;
    }

    public void setDate(SessionDate sessionDate) {
        this.date = sessionDate;
    }

}
