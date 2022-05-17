package de.dhbw.training_log.de.session.distance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceUnitTest {

    private static final double KILOMETERS_IN_METERS = 1e3;
    private static final double MILES_IN_METERS = 1.609344e3;

    @Test
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
