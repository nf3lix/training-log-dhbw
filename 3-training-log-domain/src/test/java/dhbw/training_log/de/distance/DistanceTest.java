package dhbw.training_log.de.distance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.*;
import java.util.function.Supplier;

import static dhbw.training_log.de.distance.DistanceUnit.*;
import static dhbw.training_log.de.distance.HasDistanceMatcher.hasDistance;
import static dhbw.training_log.de.test_utils.ValueObjectTest.performValueObjectTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DistanceTest {

    private final Map<DistanceUnit, Double> DISTANCE_UNITS = new HashMap<DistanceUnit, Double>() {{
        put(METERS, 1e3);
        put(KILOMETERS, 1e6);
        put(MILES, 1.609344e6);
    }};

    @Test
    @DisplayName("Convert distance to a other units")
    public void convertDistanceToUnit() {
        for(final DistanceUnit testedUnit : DistanceUnit.values()) {
            compareToOtherUnits(0.0, testedUnit);
            compareToOtherUnits(1.762, testedUnit);
            compareToOtherUnits(2.0, testedUnit);
            compareToOtherUnits(5.43, testedUnit);
            compareToOtherUnits(7.31, testedUnit);
        }
    }

    @Test
    @DisplayName("Add distance to distance object")
    public void addDistance() {
        final Distance distance = new Distance(3.0, KILOMETERS);
        assertThat(distance.add(new Distance(2.0, KILOMETERS)), hasDistance(5.0, KILOMETERS, 1e-3));
        assertThat(distance.add(new Distance(100.0, METERS)), hasDistance(3.1, KILOMETERS, 1e-3));
    }

    @Test
    @DisplayName("Exception is thrown when constructing Distance Object with negative distance")
    public void throwExceptionWhenDistanceIsNegative() {
        final Distance distance = new Distance(1.0, METERS);
        assertThrows(InvalidDistance.class, () -> new Distance(-1.0, METERS));
        assertThrows(InvalidDistance.class, () -> distance.add(new Distance(-2.0, METERS)));
    }

    @Test
    @DisplayName("Distances with same values are equal")
    public void distancesWithSameValuesAreEqual() {
        final Distance distance = new Distance(1.0, METERS);
        assertEquals(distance, distance);
        assertEquals(new Distance(3.0, METERS), new Distance(3.0, METERS));
        assertEquals(new Distance(5.43, KILOMETERS), new Distance(5.43 / 1.609344, MILES));
        assertEquals(new Distance(7.31, KILOMETERS), new Distance(7.31 / 1.609344, MILES));
    }

    @Test
    @DisplayName("Correct Value Object Behavior of class Distance")
    public void secondsValueObjectBehavior() {
        final List<Supplier<Distance>> distances = Arrays.asList(
                () -> new Distance(1.0, METERS),
                () -> new Distance(3.0, METERS)
        );
        performValueObjectTest(distances);
    }

    private void compareToOtherUnits(final Double distanceValue, final DistanceUnit unit) {
        final Iterator<DistanceUnit> iterator = DISTANCE_UNITS.keySet().stream().iterator();
        while (iterator.hasNext()) {
            final DistanceUnit currentUnit = iterator.next();
            final Double comparedUnit = DISTANCE_UNITS.get(unit);
            if(comparedUnit == null) {
                throw new AssertionFailedError("No entry for this unit " + unit + " in local distance unit map");
            }
            checkConversionOfDistance(distanceValue, unit, currentUnit);
        }
    }

    private void checkConversionOfDistance(final Double distanceValue, final DistanceUnit baseUnit, final DistanceUnit newUnit) {
        final Distance distance = new Distance(distanceValue, baseUnit);
        final Double expectedDistance = distanceValue * DISTANCE_UNITS.get(baseUnit) / DISTANCE_UNITS.get(newUnit);
        assertThat(distance, hasDistance(expectedDistance, newUnit, 1e-3));
    }

}
