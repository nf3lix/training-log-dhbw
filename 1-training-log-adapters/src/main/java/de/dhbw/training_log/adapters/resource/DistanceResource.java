package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.de.session.distance.DistanceUnit;

public final class DistanceResource {

    public static final String DISPLAYED_FORMAT = "<distance> <unit>";

    private final double distance;
    private final DistanceUnit unit;

    public DistanceResource(final String input) {
        if(!hasValidFormat(input)) {
            throw new InvalidDistanceInput();
        }
        this.distance = getDistance(input);
        this.unit = getUnit(input);
    }

    private double getDistance(final String input) {
        final String distanceInput = input.split(" ")[0];
        final String parsableString = distanceInput.replace(",", ".");
        return Double.parseDouble(parsableString);
    }

    private DistanceUnit getUnit(final String input) {
        final String unitInput = input.split(" ")[1];
        for(final DistanceUnit unit : DistanceUnit.values()) {
            if(unitInput.equalsIgnoreCase(unit.name())) {
                return unit;
            }
        }
        throw new InvalidDistanceInput();
    }

    private Boolean hasValidFormat(final String input) {
        return input.matches("[0-9]*[,.]?[0-9]*\\s[A-Za-z_]*");
    }

    public double distance() {
        return distance;
    }

    public DistanceUnit unit() {
        return unit;
    }

    @Override
    public String toString() {
        return distance + " " + unit.name();
    }
}
