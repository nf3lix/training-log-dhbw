package de.dhbw.training_log.de.session.distance;

import de.dhbw.training_log.de.aggregate_function.AggregateSubject.Averageable;
import de.dhbw.training_log.de.round.Round;

import java.util.Objects;

import static de.dhbw.training_log.de.aggregate_function.AggregateSubject.Summable;

public final class Distance implements Summable<Distance>, Averageable<Distance>, Comparable<Distance> {

    private static final DistanceUnit DEFAULT_UNIT = DistanceUnit.METERS;
    private static final double FLOATING_POINT_PRECISION = 1e-6;

    private final double distance;

    public Distance(final double distance, final DistanceUnit unit) {
        if(distance < 0) {
            throw new InvalidDistance("Distances must be zero or positive");
        }
        this.distance = distance * unit.ratioTo(DEFAULT_UNIT);
    }

    @Override
    public Distance add(final Distance newDistance) {
        return new Distance(this.distance + newDistance.distance, DEFAULT_UNIT);
    }

    @Override
    public Distance divideBy(double divisor) {
        return new Distance(this.distance / divisor, DEFAULT_UNIT);
    }

    public double getIn(final DistanceUnit unit) {
        return Round.round(this.distance * DEFAULT_UNIT.ratioTo(unit), 6);
    }

    @Override
    public int compareTo(Distance o) {
        final double diff = (this.getIn(DEFAULT_UNIT) - o.getIn(DEFAULT_UNIT));
        return Round.roundUpToInt(diff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return Math.abs(distance - distance1.distance) < FLOATING_POINT_PRECISION;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
