package de.dhbw.training_log.de;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class HasDecimalPlacesMatcher extends TypeSafeMatcher<Double> {

    static HasDecimalPlacesMatcher hasPlaces(final Integer places) {
        return new HasDecimalPlacesMatcher(places);
    }

    private final Integer places;

    HasDecimalPlacesMatcher(final Integer places) {
        this.places = places;
    }

    @Override
    protected boolean matchesSafely(Double value) {
        return getDecimalPartLength(value).equals(places);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has " + this.places + " places");
    }

    @Override
    protected void describeMismatchSafely(Double item, Description mismatchDescription) {
        mismatchDescription.appendText("has " + getDecimalPartLength(item) + " places");
    }

    private Integer getDecimalPartLength(Double value) {
        final String decimalPart = String.valueOf(value).split("\\.")[1];
        return decimalPart.length();
    }

}
