package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;

public abstract class FilterCriteriaResource<T> {

    private final String input;
    private final ComparisonOperator comparisonOperator;
    private final T resource;

    public FilterCriteriaResource(final String input) {
        this.input = input;
        this.comparisonOperator = readComparisonOperator();
        this.resource = readComparedObject();
    }

    private ComparisonOperator readComparisonOperator() {
        ComparisonOperator matchingOperator = null;
        for(final ComparisonOperator currentOperator : ComparisonOperator.values()) {
            if(input.startsWith(currentOperator.stringRepresentation())) {
                if(matchingOperator == null || matchingOperator.stringRepresentation().length() < currentOperator.stringRepresentation().length()) {
                    matchingOperator = currentOperator;
                }
            }
        }
        return matchingOperator;
    }

    private T readComparedObject() {
        final String tail = input.substring(comparisonOperator.stringRepresentation().length());
        return readComparedObject(tail);
    }

    abstract T readComparedObject(String input);

    public final ComparisonOperator getComparisonOperator() {
        return comparisonOperator;
    }

    public T getFilterValue() {
        return resource;
    }

}
