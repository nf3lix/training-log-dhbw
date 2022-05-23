package de.dhbw.training_log.adapters.usecase.search_sessions;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;

public class SearchQuery {

    private final String input;
    private String fieldName;
    private ComparisonOperator comparisonOperator;
    private String comparedValue;

    public SearchQuery(final String input) {
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
        this.fieldName = fieldName.toString();
    }

    private void readComparisonOperator() {
        for(final ComparisonOperator operator : ComparisonOperator.values()) {
            if(currentOperatorMatchesLessThan(operator)) {
                comparisonOperator = operator;
            }
        }
    }

    private void readComparedValue() {
        this.comparedValue = input.substring(fieldName.length() + comparisonOperator.stringRepresentation().length());
    }

    private boolean currentOperatorMatchesLessThan(final ComparisonOperator operator) {
        final String tail = input.substring(fieldName.length());
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
