package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;

public class QueryResource {

    private final String input;
    private String fieldName;
    private ComparisonOperator comparisonOperator;
    private String comparedValue;
    private String tail;

    public QueryResource(final String input) {
        this.input = input;
        readClassName();
        readComparisonOperator();
        readComparedValue();
    }

    private void readClassName() {
        final StringBuilder fieldName = new StringBuilder();
        if(!Character.isLetter(input.charAt(0))) {
            throw new IllegalArgumentException("");
        }
        fieldName.append(input.charAt(0));
        for(int charIndex = 1; charIndex < input.length(); charIndex++) {
            final char currentChar = input.charAt(charIndex);
            if(!Character.isLetter(currentChar) && !Character.isDigit(currentChar)) {
                break;
            }
            fieldName.append(currentChar);
        }
        this.tail = input.substring(fieldName.length());
        this.fieldName = fieldName.toString();
    }

    private ComparisonOperator readComparisonOperator() {
        for(final ComparisonOperator operator : ComparisonOperator.values()) {
            if(currentOperatorMatchesLessThan(operator)) {
                comparisonOperator = operator;
            }
        }
        return comparisonOperator;
    }

    private void readComparedValue() {
        this.comparedValue = input.substring(fieldName.length() + comparisonOperator.stringRepresentation().length());
    }

    private boolean currentOperatorMatchesLessThan(final ComparisonOperator operator) {
        if(!tail.startsWith(operator.stringRepresentation())) {
            return false;
        }
        return comparisonOperator == null || comparisonOperator.stringRepresentation().length() < operator.stringRepresentation().length();
    }

    public String getFieldName() {
        return fieldName;
    }

    public ComparisonOperator getComparisonOperator() {
        return comparisonOperator;
    }

    public String getComparedValue() {
        return comparedValue;
    }

}
