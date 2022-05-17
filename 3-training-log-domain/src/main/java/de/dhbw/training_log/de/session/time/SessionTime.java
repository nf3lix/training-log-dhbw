package de.dhbw.training_log.de.session.time;

import de.dhbw.training_log.de.aggregate_function.AggregateSubject;
import de.dhbw.training_log.de.round.Round;

import java.util.Objects;

public final class SessionTime implements AggregateSubject.Summable<SessionTime>, Comparable<SessionTime>, AggregateSubject.Averageable<SessionTime> {

    private final int minutes;
    private final int seconds;

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

    public int minutes() {
        return minutes;
    }

    public int seconds() {
        return seconds;
    }

    @Override
    public int compareTo(SessionTime o) {
        return this.totalSeconds() - o.totalSeconds();
    }

    public int totalSeconds() {
        return minutes * 60 + seconds;
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

    @Override
    public SessionTime divideBy(double divisor) {
        final int seconds = Round.roundToInt(totalSeconds() / divisor);
        return new SessionTime(new Minutes(0), new Seconds(seconds));
    }

}
