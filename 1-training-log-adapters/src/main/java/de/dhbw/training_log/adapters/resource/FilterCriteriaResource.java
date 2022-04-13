package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;

public class FilterCriteriaResource {

    private final String input;
    private final String className;
    private final ComparisonOperator comparisonOperator;

    public FilterCriteriaResource(final String input) {
        this.input = input;
        this.className = readClassName(input);
        this.comparisonOperator = readComparisonOperator();
    }

    private String readClassName(final String input) {
        final StringBuilder className = new StringBuilder();
        if(!Character.isLetter(input.charAt(0))) {
            throw new IllegalArgumentException("");
        }
        className.append(input.charAt(0));
        for(int charIndex = 1; charIndex < input.length(); charIndex++) {
            final char currentChar = input.charAt(charIndex);
            if(!Character.isLetter(currentChar) && !Character.isDigit(currentChar)) {
                break;
            }
            className.append(currentChar);
        }
        return className.toString();
    }

    private ComparisonOperator readComparisonOperator() {
        final String tail = input.substring(className.length());
        ComparisonOperator matchingOperator = null;
        for(final ComparisonOperator currentOperator : ComparisonOperator.values()) {
            if(tail.startsWith(currentOperator.stringRepresentation())) {
                if(matchingOperator == null || matchingOperator.stringRepresentation().length() < currentOperator.stringRepresentation().length()) {
                    matchingOperator = currentOperator;
                }
            }
        }
        return matchingOperator;
    }

}
