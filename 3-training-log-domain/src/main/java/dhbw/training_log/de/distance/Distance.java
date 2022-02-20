package dhbw.training_log.de.distance;

import java.util.Objects;

public final class Distance {

    private final Double distance;

    public Distance(final Double distance) {
        if(distance < 0) {
            throw new InvalidDistance("Distances must always be non-negative");
        }
        this.distance = distance;
    }

    public Distance add(final Distance newDistance) {
        return new Distance(this.distance + newDistance.distance);
    }

    public Double value() {
        return distance;
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
