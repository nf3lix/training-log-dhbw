package de.dhbw.training_log.adapters.usecase.search_sessions;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class FieldNameHasAdapterMatcher extends TypeSafeMatcher<String> {

    static FieldNameHasAdapterMatcher hasAdapter(final FilterableFieldAdapter adapter) {
        return new FieldNameHasAdapterMatcher(adapter);
    }

    private final FilterableFieldAdapter adapter;

    FieldNameHasAdapterMatcher(final FilterableFieldAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected boolean matchesSafely(final String fieldName) {
        return FilterableFieldAdapter.getAdapter(fieldName) == adapter;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has adapter ");
        description.appendValue(adapter.name());
    }

    @Override
    protected void describeMismatchSafely(String fieldName, Description mismatchDescription) {
        mismatchDescription.appendText("has adapter ");
        mismatchDescription.appendValue(FilterableFieldAdapter.getAdapter(fieldName));
    }
}
