package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.de.session.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.adapters.mapper.SessionTypeMapper.mapToAbbreviation;
import static de.dhbw.training_log.adapters.mapper.SessionTypeMapper.mapToType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SessionTypeMapperTest {

    @Test
    public void mapToAbbreviationTest() {
        for(final SessionType type : SessionType.values()) {
            assertEquals(mapToAbbreviation(type), String.valueOf(type.ordinal() + 1));
        }
    }

    @Test
    public void mapToTypeTest() {
        for(int typeIndex = 0; typeIndex < SessionType.values().length; typeIndex++) {
            assertEquals(mapToType(String.valueOf(typeIndex + 1)), SessionType.values()[typeIndex]);
        }
    }

    @Test
    public void throwExceptionWhenNoTypeMatches() {
        assertThrows(IllegalArgumentException.class, () -> mapToType("TEST"));
        assertThrows(IllegalArgumentException.class, () -> mapToType("0"));
        assertThrows(IllegalArgumentException.class, () -> mapToType(String.valueOf(SessionType.values().length + 1)));
        assertThrows(IllegalArgumentException.class, () -> mapToType(String.valueOf(SessionType.values().length + 2)));    }

}
