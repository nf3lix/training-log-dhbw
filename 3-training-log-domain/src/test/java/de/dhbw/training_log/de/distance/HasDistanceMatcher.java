package de.dhbw.training_log.de.distance;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class HasDistanceMatcher extends TypeSafeMatcher<Distance> {

    static HasDistanceMatcher hasDistance(final Double distanceValue, final DistanceUnit unit, final Double delta) {
        return new HasDistanceMatcher(distanceValue, unit, delta);
    }

    private final Double distanceValue;
    private final DistanceUnit unit;
    private final Double delta;

    HasDistanceMatcher(final Double distance, final DistanceUnit unit, final Double delta) {
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
