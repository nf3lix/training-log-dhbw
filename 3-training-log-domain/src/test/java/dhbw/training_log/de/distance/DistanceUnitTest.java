package dhbw.training_log.de.distance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dhbw.training_log.de.distance.DistanceUnit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceUnitTest {

    private static final Double KILOMETERS_IN_METERS = 1e3;
    private static final Double MILES_IN_METERS = 1.609344e3;

    @Test
    @DisplayName("Calculate correct ratios between two given units")
    public void calculateCorrectRatioBetweenUnits() {
        assertEquals(METERS.ratioTo(METERS), 1);
        assertEquals(METERS.ratioTo(KILOMETERS), 1 / KILOMETERS_IN_METERS);
        assertEquals(METERS.ratioTo(MILES), 1 / MILES_IN_METERS);

        assertEquals(KILOMETERS.ratioTo(METERS), KILOMETERS_IN_METERS);
        assertEquals(KILOMETERS.ratioTo(KILOMETERS), 1);
        assertEquals(KILOMETERS.ratioTo(MILES), 1000 / MILES_IN_METERS);

        assertEquals(MILES.ratioTo(METERS), MILES_IN_METERS);
        assertEquals(MILES.ratioTo(KILOMETERS), MILES_IN_METERS / 1000);
        assertEquals(MILES.ratioTo(MILES), 1);
    }

}
