package de.dhbw.training_log.de.comparison_operator;

public enum ComparisonOperator {

    EQUAL_TO {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) == 0;
        }
    },

    LESS_THAN {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) > 0;
        }
    },

    GREATER_THAN {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) < 0;
        }
    },

    LESS_OR_EQUAL {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) >= 0;
        }
    },

    GREATER_OR_EQUAL {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) <= 0;
        }
    },

    NOT_EQUAL {
        @Override
        public <T extends Comparable<T>> boolean matches(T object1, T object2) {
            return object1.compareTo(object2) != 0;
        }
    };

    /**
     * for a given comparison operator ∘, return whether comparison operation "firstParam ∘ secondParam" is true
     * @param object1 first param of comparison operation
     * @param object2 second param of comparison operator
     * @param <T> comparable class
     * @return result of the comparison
     */
    public abstract <T extends Comparable<T>> boolean matches(T object1, T object2);

}
