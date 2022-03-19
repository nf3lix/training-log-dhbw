package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.adapters.resource.InvalidDistanceInput;
import dhbw.training_log.de.distance.DistanceUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DistanceResourceTest {

    @Test
    public void throwExceptionWhenInputHasNotValidFormat() {
        assertThrows(InvalidDistanceInput.class, () -> new DistanceResource(""));
        assertThrows(InvalidDistanceInput.class, () -> new DistanceResource("1"));
        assertThrows(InvalidDistanceInput.class, () -> new DistanceResource("TEST"));
        assertThrows(InvalidDistanceInput.class, () -> new DistanceResource("1.1."));
    }

    @Test
    public void assignDistance() {
        final DistanceResource distance1 = new DistanceResource("10 METERS");
        final DistanceResource distance2 = new DistanceResource("250 METERS");
        final DistanceResource distance3 = new DistanceResource("2000 METERS");
        assertEquals(distance1.distance(), 10);
        assertEquals(distance2.distance(), 250);
        assertEquals(distance3.distance(), 2000);
    }

    @Test
    public void assignUnit() {
        for(DistanceUnit unit : DistanceUnit.values()) {
            final DistanceResource distance1 = new DistanceResource("10 " + unit.name());
            final DistanceResource distance2 = new DistanceResource("10 " + unit.name().toLowerCase());
            assertEquals(distance1.unit(), unit);
            assertEquals(distance2.unit(), unit);
        }
    }

    @Test
    public void throwExceptionWhenUnitNotFound() {
        assertThrows(InvalidDistanceInput.class, () -> new DistanceResource("10 TEST"));
    }

    @Test
    public void displayText() {
        for(DistanceUnit unit : DistanceUnit.values()) {
            final DistanceResource distance1 = new DistanceResource("10 " + unit.name());
            final DistanceResource distance2 = new DistanceResource("10 " + unit.name().toLowerCase());
            final DistanceResource distance3 = new DistanceResource("12 " + unit.name());
            final DistanceResource distance4 = new DistanceResource("12.0 " + unit.name().toLowerCase());
            assertEquals(distance1.toString(), "10.0 " + unit.name());
            assertEquals(distance2.toString(), "10.0 " + unit.name());
            assertEquals(distance3.toString(), "12.0 " + unit.name());
            assertEquals(distance4.toString(), "12.0 " + unit.name());
        }
    }

}
