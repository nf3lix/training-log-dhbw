package dhbw.training_log.de.distance;

import java.util.Objects;

import static dhbw.training_log.de.round.Round.round;

public final class Distance {

    private static final DistanceUnit DEFAULT_UNIT = DistanceUnit.METERS;
    private final Double distance;

    public Distance(final Double distance, final DistanceUnit unit) {
        if(distance < 0) {
            throw new InvalidDistance("Distances must always be non-negative");
        }
        this.distance = round(distance * unit.ratioTo(DEFAULT_UNIT), 6);
    }

    public Distance add(final Distance newDistance) {
        return new Distance(this.distance + newDistance.distance, DEFAULT_UNIT);
    }

    public Double getIn(final DistanceUnit unit) {
        return round(this.distance * DEFAULT_UNIT.ratioTo(unit), 6);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return Objects.equals(distance, distance1.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
