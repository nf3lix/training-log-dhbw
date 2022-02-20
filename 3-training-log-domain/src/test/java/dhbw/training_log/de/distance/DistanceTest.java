package dhbw.training_log.de.distance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistanceTest {

    @Test
    @DisplayName("Exception is thrown when constructing Distance Object with negative distance")
    public void throwExceptionWhenDistanceIsNegative() {
        final Distance distance = new Distance(1.0);
        assertThrows(InvalidDistance.class, () -> new Distance(-1.0));
        assertThrows(InvalidDistance.class, () -> new Distance(-2.0));
        assertThrows(InvalidDistance.class, () -> distance.add(new Distance(-2.0)));
        assertThrows(InvalidDistance.class, () -> distance.add(new Distance(-3.0)));
    }

    @Test
    @DisplayName("Distance represents correct value")
    public void returnCorrectDistanceValue() {
        assertEquals((new Distance(0.0)).value(), 0.0);
        assertEquals((new Distance(1.0)).value(), 1.0);
        assertEquals(joinDistances(0.0, 1.0).value(), 1.0);
        assertEquals(joinDistances(1.0, 1.0).value(), 2.0);
        assertEquals(joinDistances(2.0, 1.0).value(), 3.0);
        assertEquals(joinDistances(2.0, 4.0).value(), 6.0);
    }

    @Test
    @DisplayName("Distances with same values are equal")
    public void distancesWithSameValuesAreEqual() {
        final Distance distance = new Distance(1.0);
        assertEquals(distance, distance);
        assertEquals(new Distance(3.0), new Distance(3.0));
        assertEquals(new Distance(5.0), new Distance(5.0));
        assertEquals(new Distance(5.0), new Distance(5.0));
    }

    @Test
    @DisplayName("Distances with different values are unequal")
    public void distancesWithDifferentValuesAreUnequal() {
        assertNotEquals(new Distance(1.0), new Distance(0.0));
        assertNotEquals(new Distance(2.0), new Distance(4.0));
        assertNotEquals(new Distance(3.0), new Distance(5.0));
        assertNotEquals(new Distance(3.0), null);
    }

    @Test
    @DisplayName("Distances with same values have same hash codes")
    public void distancesWithSameValueHaveSameHashCodes() {
        assertEquals(new Distance(1.0).hashCode(), new Distance(1.0).hashCode());
        assertEquals(new Distance(2.0).hashCode(), new Distance(2.0).hashCode());
        assertEquals(new Distance(3.0).hashCode(), new Distance(3.0).hashCode());
    }

    @Test
    @DisplayName("Distances with different values have different hash codes")
    public void distancesWithDifferentValueHaveDifferentHashCodes() {
        assertNotEquals(new Distance(1.0).hashCode(), new Distance(2.0).hashCode());
        assertNotEquals(new Distance(3.0).hashCode(), new Distance(1.0).hashCode());
        assertNotEquals(new Distance(2.0).hashCode(), new Distance(3.0).hashCode());
    }

    private Distance joinDistances(final Double a, final Double b) {
        final Distance distanceA = new Distance(a);
        final Distance distanceB = new Distance(b);
        return distanceA.add(distanceB);
    }

}
