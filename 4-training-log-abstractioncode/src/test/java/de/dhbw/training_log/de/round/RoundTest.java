package de.dhbw.training_log.de.round;

import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.round.HasDecimalPlacesMatcher.hasPlaces;
import static de.dhbw.training_log.de.round.Round.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundTest {

    @Test
    public void roundToPlaces() {
        assertThat(round(1.111, 2), hasPlaces(2));
        assertThat(round(1.111111, 2), hasPlaces(2));
        assertThat(round(1.11, 3), hasPlaces(2));
        assertThat(round(1.1111, 3), hasPlaces(3));
        assertThat(round(1.111111, 3), hasPlaces(3));
    }

    @Test
    public void roundHalfUpPositiveNumbers() {
        assertEquals(round(1.005, 2), 1.01);
        assertEquals(round(1.006, 2), 1.01);
        assertEquals(round(1.007, 2), 1.01);
        assertEquals(round(1.008, 2), 1.01);
        assertEquals(round(1.009, 2), 1.01);
    }

    @Test
    public void roundHalfUpNegativeNumbers() {
        assertEquals(round(-0.804, 2), -0.80);
        assertEquals(round(-0.803, 2), -0.80);
        assertEquals(round(-0.802, 2), -0.80);
        assertEquals(round(-0.801, 2), -0.80);
        assertEquals(round(-0.800, 2), -0.80);
        assertEquals(round(-0.01, 1), 0.0);
    }

    @Test
    public void roundHalfDownPositiveNumbers() {
        assertEquals(round(1.004, 2), 1.0);
        assertEquals(round(1.003, 2), 1.0);
        assertEquals(round(1.002, 2), 1.0);
        assertEquals(round(1.001, 2), 1.0);
        assertEquals(round(1.000, 2), 1.0);
    }

    @Test
    public void roundHalfDownNegativeNumbers() {
        assertEquals(round(-0.805, 2), -0.81);
        assertEquals(round(-0.806, 2), -0.81);
        assertEquals(round(-0.807, 2), -0.81);
        assertEquals(round(-0.808, 2), -0.81);
        assertEquals(round(-0.809, 2), -0.81);
        assertEquals(round(-0.81, 2), -0.81);
    }

    @Test
    public void throwExceptionWhenPlacesAreLessThanOne() {
        assertThrows(IllegalStateException.class, () -> round(1.00, -1));
        assertThrows(IllegalStateException.class, () -> round(1.00, 0));
    }

    @Test
    public void roundHalfDownToPositiveInt() {
        assertEquals(roundToInt(1.0), 1);
        assertEquals(roundToInt(1.1), 1);
        assertEquals(roundToInt(1.2), 1);
        assertEquals(roundToInt(1.3), 1);
        assertEquals(roundToInt(1.4), 1);
    }

    @Test
    public void roundHalfUpToPositiveInt() {
        assertEquals(roundToInt(1.5), 2);
        assertEquals(roundToInt(1.6), 2);
        assertEquals(roundToInt(1.7), 2);
        assertEquals(roundToInt(1.8), 2);
        assertEquals(roundToInt(1.9), 2);
    }

    @Test
    public void roundHalfDownToNegativeInt() {
        assertEquals(roundToInt(-1.5), -2);
        assertEquals(roundToInt(-1.6), -2);
        assertEquals(roundToInt(-1.7), -2);
        assertEquals(roundToInt(-1.8), -2);
        assertEquals(roundToInt(-1.9), -2);
    }

    @Test
    public void roundHalfUpToNegativeInt() {
        assertEquals(roundToInt(-1.4), -1);
        assertEquals(roundToInt(-1.3), -1);
        assertEquals(roundToInt(-1.2), -1);
        assertEquals(roundToInt(-1.1), -1);
        assertEquals(roundToInt(-1.0), -1);
    }

    @Test
    public void roundUpToPositiveInt() {
        for(double positiveNumber = 0.1; positiveNumber <= 1.0; positiveNumber += 0.1) {
            assertEquals(roundUpToInt(positiveNumber), 1);
        }
    }

    @Test
    public void roundUpToNegativeInt() {
        for(double positiveNumber = -0.1; positiveNumber >= -1.0; positiveNumber -= 0.1) {
            assertEquals(roundUpToInt(positiveNumber), -1);
        }
    }

}
