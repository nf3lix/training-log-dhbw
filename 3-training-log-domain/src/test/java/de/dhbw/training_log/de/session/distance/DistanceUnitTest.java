package de.dhbw.training_log.de.session.distance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceUnitTest {

    private static final Double KILOMETERS_IN_METERS = 1e3;
    private static final Double MILES_IN_METERS = 1.609344e3;

    @Test
    @DisplayName("Calculate correct ratios between two given units")
    public void calculateCorrectRatioBetweenUnits() {
        Assertions.assertEquals(DistanceUnit.METERS.ratioTo(DistanceUnit.METERS), 1);
        Assertions.assertEquals(DistanceUnit.METERS.ratioTo(DistanceUnit.KILOMETERS), 1 / KILOMETERS_IN_METERS);
        Assertions.assertEquals(DistanceUnit.METERS.ratioTo(DistanceUnit.MILES), 1 / MILES_IN_METERS);

        Assertions.assertEquals(DistanceUnit.KILOMETERS.ratioTo(DistanceUnit.METERS), KILOMETERS_IN_METERS);
        Assertions.assertEquals(DistanceUnit.KILOMETERS.ratioTo(DistanceUnit.KILOMETERS), 1);
        Assertions.assertEquals(DistanceUnit.KILOMETERS.ratioTo(DistanceUnit.MILES), 1000 / MILES_IN_METERS);

        Assertions.assertEquals(DistanceUnit.MILES.ratioTo(DistanceUnit.METERS), MILES_IN_METERS);
        Assertions.assertEquals(DistanceUnit.MILES.ratioTo(DistanceUnit.KILOMETERS), MILES_IN_METERS / 1000);
        Assertions.assertEquals(DistanceUnit.MILES.ratioTo(DistanceUnit.MILES), 1);
    }

}
