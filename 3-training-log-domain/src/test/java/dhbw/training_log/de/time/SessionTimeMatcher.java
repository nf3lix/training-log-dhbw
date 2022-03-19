package dhbw.training_log.de.time;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class SessionTimeMatcher extends TypeSafeMatcher<SessionTime> {

    static SessionTimeMatcher hasTime(final Integer minutes, final Integer seconds) {
        return new SessionTimeMatcher(minutes, seconds);
    }

    private final Integer minutes;
    private final Integer seconds;

    SessionTimeMatcher(final Integer minutes, final Integer seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    protected boolean matchesSafely(SessionTime sessionTime) {
        return sessionTime.minutes().equals(this.minutes) && sessionTime.seconds().equals(this.seconds);
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
