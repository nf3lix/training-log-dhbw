package de.dhbw.training_log.de.comparison_operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ComparisonOperator {

    EQUAL_TO("=", "==") {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) == 0;
        }
    },

    LESS_THAN("<") {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) > 0;
        }
    },

    GREATER_THAN(">") {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) < 0;
        }
    },

    LESS_OR_EQUAL("<=", "=<") {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) >= 0;
        }
    },

    GREATER_OR_EQUAL(">=", "=>") {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) <= 0;
        }
    },

    NOT_EQUAL("!=") {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) != 0;
        }
    };

    private final List<String> operatorStrings = new ArrayList<>();

    ComparisonOperator(final String operatorString, final String... operatorStrings) {
        this.operatorStrings.add(operatorString);
        this.operatorStrings.addAll(Arrays.asList(operatorStrings));
    }

    /**
     * for a given comparison operator ∘, return whether comparison operation "firstParam ∘ secondParam" is true
     * @param object1 first param of comparison operation
     * @param object2 second param of comparison operator
     * @param <T> comparable class
     * @return result of the comparison
     */
    public abstract <T extends Comparable<T>> boolean matches(T object1, T object2);

}
