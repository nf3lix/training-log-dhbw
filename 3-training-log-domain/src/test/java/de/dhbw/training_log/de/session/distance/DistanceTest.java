package de.dhbw.training_log.de.session.distance;

import de.dhbw.training_log.de.test_utils.ValueObjectTest;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.*;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    private final Map<DistanceUnit, Double> DISTANCE_UNITS = new HashMap<DistanceUnit, Double>() {{
        put(METERS, 1e3);
        put(KILOMETERS, 1e6);
        put(MILES, 1.609344e6);
    }};

    @Test
    public void convertDistanceToUnit() {
        for(final DistanceUnit testedUnit : values()) {
            compareToOtherUnits(0.0, testedUnit);
            compareToOtherUnits(1.762, testedUnit);
            compareToOtherUnits(2.0, testedUnit);
            compareToOtherUnits(5.43, testedUnit);
            compareToOtherUnits(7.31, testedUnit);
        }
    }

    @Test
    public void addDistance() {
        final Distance distance = new Distance(3.0, KILOMETERS);
        MatcherAssert.assertThat(distance.add(new Distance(2.0, KILOMETERS)), HasDistanceMatcher.hasDistance(5.0, KILOMETERS, 1e-3));
        MatcherAssert.assertThat(distance.add(new Distance(100.0, METERS)), HasDistanceMatcher.hasDistance(3.1, KILOMETERS, 1e-3));
    }

    @Test
    public void throwExceptionWhenDistanceIsNegative() {
        final Distance distance = new Distance(1.0, METERS);
        assertThrows(InvalidDistance.class, () -> new Distance(-1.0, METERS));
        assertThrows(InvalidDistance.class, () -> distance.add(new Distance(-2.0, METERS)));
    }

    @Test
    public void distancesWithSameValuesAreEqual() {
        final Distance distance = new Distance(1.0, METERS);
        assertEquals(distance, distance);
        assertEquals(new Distance(3.0, METERS), new Distance(3.0, METERS));
        assertEquals(new Distance(5.43, KILOMETERS), new Distance(5.43 / 1.609344, MILES));
        assertEquals(new Distance(7.31, KILOMETERS), new Distance(7.31 / 1.609344, MILES));
    }

    @Test
    public void secondsValueObjectBehavior() {
        final List<Supplier<Distance>> distances = Arrays.asList(
                () -> new Distance(1.0, METERS),
                () -> new Distance(3.0, METERS)
        );
        ValueObjectTest.performValueObjectTest(distances);
    }

    @Test
    public void divide() {
        final Distance distance1 = new Distance(10.0, KILOMETERS);
        final Distance distance2 = distance1.divideBy(10.0);
        assertEquals(distance2.getIn(KILOMETERS), 1.0);
    }

    @Test
    public void compareDistances() {
        final List<Distance> distances = new ArrayList<>();
        distances.add(new Distance(10.0, KILOMETERS));
        distances.add(new Distance(11.0, KILOMETERS));
        distances.add(new Distance(9000.0, METERS));
        distances.add(new Distance(10000.0, METERS));
        distances.add(new Distance(2.0, MILES));
        final List<Distance> sortedList = distances.stream().sorted().collect(Collectors.toList());
        assertEquals(sortedList.get(0), new Distance(2.0, MILES));
        assertEquals(sortedList.get(1), new Distance(9000.0, METERS));
        assertEquals(sortedList.get(2), new Distance(10.0, KILOMETERS));
        assertEquals(sortedList.get(3), new Distance(10.0, KILOMETERS));
        assertEquals(sortedList.get(4), new Distance(11.0, KILOMETERS));
    }

    @Test
    public void compareDistancesWithDecimalShareOnly() {
        final Distance distance1 = new Distance(0.1, METERS);
        final Distance distance2 = new Distance(0.05, METERS);
        assertNotEquals(0, distance1.compareTo(distance2));
    }

    private void compareToOtherUnits(final double distanceValue, final DistanceUnit unit) {
        final Iterator<DistanceUnit> iterator = DISTANCE_UNITS.keySet().stream().iterator();
        while (iterator.hasNext()) {
            final DistanceUnit currentUnit = iterator.next();
            checkConversionOfDistance(distanceValue, unit, currentUnit);
        }
    }

    private void checkConversionOfDistance(final double distanceValue, final DistanceUnit baseUnit, final DistanceUnit newUnit) {
        final Distance distance = new Distance(distanceValue, baseUnit);
        final double expectedDistance = distanceValue * DISTANCE_UNITS.get(baseUnit) / DISTANCE_UNITS.get(newUnit);
        MatcherAssert.assertThat(distance, HasDistanceMatcher.hasDistance(expectedDistance, newUnit, 1e-3));
    }

}
