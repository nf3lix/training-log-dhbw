package de.dhbw.training_log.de.comparison_operator;

import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.comparison_operator.ComparisonOperator.LESS_OR_EQUAL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LessOrEqualOperatorTest {

    @Test
    public void returnTrueWhenComparedObjectIsLess() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(0);
        assertTrue(LESS_OR_EQUAL.matches(o1, o2));
    }

    @Test
    public void returnTrueWhenComparedObjectIsEqual() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(1);
        assertTrue(LESS_OR_EQUAL.matches(o1, o2));
    }

    @Test
    public void returnFalseWhenComparedObjectIsGreater() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(2);
        assertFalse(LESS_OR_EQUAL.matches(o1, o2));
    }

}
