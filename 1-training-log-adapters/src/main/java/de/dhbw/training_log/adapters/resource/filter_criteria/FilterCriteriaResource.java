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
        for(final ComparisonOperator operator : ComparisonOperator.values()) {
            if(currentOperatorMatchesLessThan(operator)) {
                comparisonOperator = operator;
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

    private boolean currentOperatorMatchesLessThan(final ComparisonOperator operator) {
        if(!input.startsWith(operator.stringRepresentation())) {
            return false;
        }
        return comparisonOperator == null || comparisonOperator.stringRepresentation().length() < operator.stringRepresentation().length();
    }

}
