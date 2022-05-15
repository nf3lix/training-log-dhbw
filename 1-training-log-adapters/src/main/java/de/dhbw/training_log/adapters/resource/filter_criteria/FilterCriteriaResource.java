package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;

public abstract class FilterCriteriaResource<T> {

    private final String input;
    private final ComparisonOperator comparisonOperator;
    private final T resource;

    public FilterCriteriaResource(final String input) {
        this.input = input;
        this.comparisonOperator = readComparisonOperator();
        this.resource = parseStringValue();
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

    private T parseStringValue() {
        final String tail = input.substring(comparisonOperator.stringRepresentation().length());
        return parseStringValue(tail);
    }

    abstract T parseStringValue(String input);

    public final ComparisonOperator getComparisonOperator() {
        return comparisonOperator;
    }

    public T getFilterValue() {
        return resource;
    }

}
