package de.dhbw.training_log.adapters.mapper;

import dhbw.training_log.de.training_session_type.SessionType;

import java.util.HashMap;
import java.util.Map;

public class SessionTypeMapper {

    private static final Map<String, SessionType> SESSION_TYPES = new HashMap<>();

    static {
        for(final SessionType type : SessionType.values()) {
            SESSION_TYPES.put(mapToAbbreviation(type), type);
        }
    }

    public static String mapToAbbreviation(final SessionType type) {
        return String.valueOf(type.ordinal() + 1);
    }

    public static SessionType mapToType(String abbreviation) {
        final SessionType type = SESSION_TYPES.get(abbreviation);
        if(type == null) {
            throw new IllegalArgumentException("There's no such Training session type");
        }
        return type;
    }

}
