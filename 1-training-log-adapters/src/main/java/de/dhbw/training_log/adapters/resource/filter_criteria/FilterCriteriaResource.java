package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;

public abstract class FilterCriteriaResource<T> {

    private final String input;
    private ComparisonOperator comparisonOperator;
    private final T resource;

    public FilterCriteriaResource(final String input) {
        this.input = input;
        this.comparisonOperator = readComparisonOperator();
        this.resource = readComparedObject();
    }

    private ComparisonOperator readComparisonOperator() {
        for(final ComparisonOperator currentOperator : ComparisonOperator.values()) {
            // if current comparison operator matches larger range of input than matchingOperator
            if(input.startsWith(currentOperator.stringRepresentation())) {
                if(comparisonOperator == null || comparisonOperator.stringRepresentation().length() < currentOperator.stringRepresentation().length()) {
                    comparisonOperator = currentOperator;
                }
            }
        }
        return comparisonOperator;
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
