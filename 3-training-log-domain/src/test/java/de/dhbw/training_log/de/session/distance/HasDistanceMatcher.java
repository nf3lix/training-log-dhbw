package de.dhbw.training_log.de.session.distance;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class HasDistanceMatcher extends TypeSafeMatcher<Distance> {

    static HasDistanceMatcher hasDistance(final double distanceValue, final DistanceUnit unit, final double delta) {
        return new HasDistanceMatcher(distanceValue, unit, delta);
    }

    private final double distanceValue;
    private final DistanceUnit unit;
    private final double delta;

    HasDistanceMatcher(final double distance, final DistanceUnit unit, final double delta) {
        this.distanceValue = distance;
        this.unit = unit;
        this.delta = delta;
    }

    @Override
    protected boolean matchesSafely(final Distance distance) {
        return Math.abs(distance.getIn(unit) - distanceValue) <= delta;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("has distance ");
        description.appendValue(distanceValue + " " + unit.name());
    }

    @Override
    protected void describeMismatchSafely(Distance item, Description mismatchDescription) {
        mismatchDescription.appendText("has distance ");
        mismatchDescription.appendValue(item.getIn(unit) + " " + unit.name());
    }

}
