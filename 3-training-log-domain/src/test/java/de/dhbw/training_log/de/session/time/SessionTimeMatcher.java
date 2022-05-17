package de.dhbw.training_log.de.session.time;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class SessionTimeMatcher extends TypeSafeMatcher<SessionTime> {

    static SessionTimeMatcher hasTime(final int minutes, final int seconds) {
        return new SessionTimeMatcher(minutes, seconds);
    }

    private final int minutes;
    private final int seconds;

    SessionTimeMatcher(final int minutes, final int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    protected boolean matchesSafely(SessionTime sessionTime) {
        return sessionTime.minutes() == this.minutes && sessionTime.seconds() == this.seconds;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has time " + this.minutes + " minutes; " + this.seconds + " seconds");
    }

    @Override
    protected void describeMismatchSafely(SessionTime item, Description mismatchDescription) {
        mismatchDescription.appendText("has time " + item.minutes() + " minutes; " + item.seconds() + " seconds");
    }

}
