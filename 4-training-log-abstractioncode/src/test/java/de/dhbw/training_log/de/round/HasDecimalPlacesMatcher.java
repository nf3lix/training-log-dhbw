package de.dhbw.training_log.de.round;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class HasDecimalPlacesMatcher extends TypeSafeMatcher<Double> {

    static HasDecimalPlacesMatcher hasPlaces(final int places) {
        return new HasDecimalPlacesMatcher(places);
    }

    private final int places;

    HasDecimalPlacesMatcher(final int places) {
        this.places = places;
    }

    @Override
    protected boolean matchesSafely(Double value) {
        return getDecimalPartLength(value) == places;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has " + this.places + " places");
    }

    @Override
    protected void describeMismatchSafely(Double item, Description mismatchDescription) {
        mismatchDescription.appendText("has " + getDecimalPartLength(item) + " places");
    }

    private int getDecimalPartLength(double value) {
        final String decimalPart = String.valueOf(value).split("\\.")[1];
        return decimalPart.length();
    }

}
