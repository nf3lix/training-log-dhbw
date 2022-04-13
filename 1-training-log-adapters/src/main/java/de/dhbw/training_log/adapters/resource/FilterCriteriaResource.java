package de.dhbw.training_log.adapters.resource;

public class FilterCriteriaResource {

    public FilterCriteriaResource(final String input) {
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

}
