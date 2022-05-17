package de.dhbw.training_log.de.session.time;

import java.util.Objects;

public final class Minutes {

    private final int value;

    public Minutes(final int minutes) {
        if(minutes < 0) {
            throw new IllegalStateException("Minutes must always be non-negative");
        }
        this.value = minutes;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minutes minutes = (Minutes) o;
        return Objects.equals(value, minutes.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
