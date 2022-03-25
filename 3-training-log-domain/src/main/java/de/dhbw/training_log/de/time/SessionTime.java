package de.dhbw.training_log.de.time;

import java.util.Objects;

public final class SessionTime {

    private final Integer minutes;
    private final Integer seconds;

    public SessionTime(final Minutes minutes, final Seconds seconds) {
        this.minutes = minutes.value() + seconds.getFullMinutes();
        this.seconds = seconds.residualSeconds();
    }

    public SessionTime add(final SessionTime time) {
        return new SessionTime(
                new Minutes(this.minutes + time.minutes),
                new Seconds(this.seconds + time.seconds)
        );
    }

    public Integer minutes() {
        return minutes;
    }

    public Integer seconds() {
        return seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionTime that = (SessionTime) o;
        return Objects.equals(minutes, that.minutes) && Objects.equals(seconds, that.seconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, seconds);
    }

}
