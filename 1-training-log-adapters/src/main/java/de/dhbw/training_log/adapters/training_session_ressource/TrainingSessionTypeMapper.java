package de.dhbw.training_log.adapters.training_session_ressource;

import dhbw.training_log.de.training_session_type.TrainingSessionType;

import java.util.HashMap;
import java.util.Map;

public class TrainingSessionTypeMapper {

    private static final Map<String, TrainingSessionType> SESSION_TYPES = new HashMap<>();

    static {
        for(final TrainingSessionType type : TrainingSessionType.values()) {
            SESSION_TYPES.put(mapToAbbreviation(type), type);
        }
    }

    public static String mapToAbbreviation(final TrainingSessionType type) {
        return String.valueOf(type.ordinal() + 1);
    }

    public static TrainingSessionType mapToType(String abbreviation) {
        final TrainingSessionType type = SESSION_TYPES.get(abbreviation);
        if(type == null) {
            throw new IllegalArgumentException("There's no such Training session type");
        }
        return type;
    }

}
