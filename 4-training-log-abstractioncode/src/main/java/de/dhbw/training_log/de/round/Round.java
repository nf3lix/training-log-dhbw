package de.dhbw.training_log.de.round;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Round {

    /**
     * <p>Round a Double value (half up)</p>
     * @param value value to be rounded
     * @param places decimal places to round to
     * @return rounded value
     */
    public static double round(final double value, final int places) {
        if(places <= 0) {
            throw new IllegalStateException("Cannot round Double value to less than one places");
        }
        BigDecimal decimal = new BigDecimal(Double.toString(value));
        return decimal.setScale(places, RoundingMode.HALF_UP).doubleValue();
    }

    public static int roundToInt(final double value) {
        BigDecimal decimal = new BigDecimal(Double.toString(value));
        return (int) decimal.setScale(0, RoundingMode.HALF_UP).doubleValue();
    }

    public static int roundUpToInt(final double value) {
        BigDecimal decimal = new BigDecimal(Double.toString(value));
        return (int) decimal.setScale(0, RoundingMode.UP).doubleValue();
    }

}
