package de.dhbw.training_log.de.session.time;

import java.util.Objects;

public final class Seconds {

    private final Integer value;

    public Seconds(final Integer seconds) {
        if(seconds < 0) {
            throw new IllegalStateException("Seconds must always be non-negative");
        }
        this.value = seconds;
    }

    Integer getFullMinutes() {
        int seconds = value;
        Integer fullMinutes = 0;
        while(seconds >= 60) {
            fullMinutes++;
            seconds -= 60;
        }
        return fullMinutes;
    }

    Integer residualSeconds() {
        return value % 60;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seconds seconds = (Seconds) o;
        return Objects.equals(value, seconds.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
