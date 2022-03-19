package de.dhbw.training_log.adapters;

import de.dhbw.training_log.adapters.training_session_ressource.DistanceResource;
import de.dhbw.training_log.adapters.training_session_ressource.SessionTimeResource;
import dhbw.training_log.de.training_session_type.TrainingSessionType;

import java.util.UUID;

public final class TrainingSessionResource {

    private final UUID id;
    private final DistanceResource distance;
    private final SessionTimeResource sessionTime;
    private final String description;
    private final TrainingSessionType type;

    public TrainingSessionResource(final UUID id,
                                   final DistanceResource distance,
                                   final SessionTimeResource sessionTime,
                                   final String description,
                                   final TrainingSessionType type) {
        this.id = id;
        this.distance = distance;
        this.sessionTime = sessionTime;
        this.description = description;
        this.type = type;
    }

    public UUID id() {
        return id;
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

    public TrainingSessionType type() {
        return type;
    }

    public String[] toCsvLine() {
        final String[] line = new String[5];
        line[0] = id().toString();
        line[1] = distance().toString();
        line[2] = sessionTime().toString();
        line[3] = description();
        line[4] = type().name();
        return line;
    }

    public static TrainingSessionResource fromCsvLine(final String[] line) {
        return new TrainingSessionResource(
                UUID.fromString(line[0]),
                new DistanceResource(line[1]),
                new SessionTimeResource(line[2]),
                line[3],
                TrainingSessionType.valueOf(TrainingSessionType.class, line[4])
        );
    }

}
