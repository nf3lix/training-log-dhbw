package dhbw.training_log.de.distance;

public enum DistanceUnit {

    METERS(1e3),
    KILOMETERS(1e6),
    MILES(1.609344e6);

    private final Double inMillimeters;

    DistanceUnit(final Double inMillimeters) {
        this.inMillimeters = inMillimeters;
    }

    /**
     * <p>Gives the ratio between to distance units</p>
     * @param unit the distance unit to convert to
     * @return ratio to given unit
     */
    public Double ratioTo(final DistanceUnit unit) {
        return this.inMillimeters / unit.inMillimeters;
    }

}
