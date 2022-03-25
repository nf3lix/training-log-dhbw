package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.de.training_session_type.SessionType;

import java.time.LocalDate;
import java.util.UUID;

public final class SessionResource {

    private final UUID id;
    private final SessionDateResource sessionDate;
    private final DistanceResource distance;
    private final SessionTimeResource sessionTime;
    private final String description;
    private final SessionType type;

    public SessionResource(final UUID id,
                           final SessionDateResource sessionDate,
                           final DistanceResource distance,
                           final SessionTimeResource sessionTime,
                           final String description,
                           final SessionType type) {
        this.id = id;
        this.sessionDate = sessionDate;
        this.distance = distance;
        this.sessionTime = sessionTime;
        this.description = description;
        this.type = type;
    }

    public UUID id() {
        return id;
    }

    public SessionDateResource sessionDate() {
        return sessionDate;
    }

    public DistanceResource distance() {
        return distance;
    }

    public SessionTimeResource sessionTime() {
        return sessionTime;
    }

    public String description() {
        return description;
    }

    public SessionType type() {
        return type;
    }

    public String[] toCsvLine() {
        final String[] line = new String[6];
        line[0] = id().toString();
        line[1] = sessionDate().toString();
        line[2] = distance().toString();
        line[3] = sessionTime().toString();
        line[4] = description();
        line[5] = type().name();
        return line;
    }

    public static SessionResource fromCsvLine(final String[] line) {
        return new SessionResource(
                UUID.fromString(line[0]),
                new SessionDateResource(line[1]),
                new DistanceResource(line[2]),
                new SessionTimeResource(line[3]),
                line[4],
                SessionType.valueOf(SessionType.class, line[5])
        );
    }

    @Override
    public String toString() {
        return id().toString() + " - "
                + sessionDate().toString() + " - "
                + distance().toString() + " - "
                + sessionTime().toString() + " - "
                + description() + " - "
                + type().name();
    }
}
