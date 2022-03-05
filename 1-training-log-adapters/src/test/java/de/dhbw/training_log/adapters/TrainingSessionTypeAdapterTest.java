package de.dhbw.training_log.adapters;

import dhbw.training_log.de.training_session_type.TrainingSessionType;
import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.adapters.training_session_ressource.TrainingSessionTypeMapper.mapToAbbreviation;
import static de.dhbw.training_log.adapters.training_session_ressource.TrainingSessionTypeMapper.mapToType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainingSessionTypeAdapterTest {

    @Test
    public void mapToAbbreviationTest() {
        for(final TrainingSessionType type : TrainingSessionType.values()) {
            assertEquals(mapToAbbreviation(type), String.valueOf(type.ordinal() + 1));
        }
    }

    @Test
    public void mapToTypeTest() {
        for(int typeIndex = 0; typeIndex < TrainingSessionType.values().length; typeIndex++) {
            assertEquals(mapToType(String.valueOf(typeIndex + 1)), TrainingSessionType.values()[typeIndex]);
        }
    }

    @Test
    public void throwExceptionWhenNoTypeMatches() {
        assertThrows(IllegalArgumentException.class, () -> mapToType("TEST"));
        assertThrows(IllegalArgumentException.class, () -> mapToType("0"));
        assertThrows(IllegalArgumentException.class, () -> mapToType(String.valueOf(TrainingSessionType.values().length + 1)));
        assertThrows(IllegalArgumentException.class, () -> mapToType(String.valueOf(TrainingSessionType.values().length + 2)));    }

}
