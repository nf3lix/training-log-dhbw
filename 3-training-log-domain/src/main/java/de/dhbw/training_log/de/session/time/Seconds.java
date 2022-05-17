package de.dhbw.training_log.de.session.time;

import java.util.Objects;

public final class Seconds {

    private final int value;

    public Seconds(final int seconds) {
        if(seconds < 0) {
            throw new IllegalStateException("Seconds must always be non-negative");
        }
        this.value = seconds;
    }

    int getFullMinutes() {
        int seconds = value;
        int fullMinutes = 0;
        while(seconds >= 60) {
            fullMinutes++;
            seconds -= 60;
        }
        return fullMinutes;
    }

    int residualSeconds() {
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
