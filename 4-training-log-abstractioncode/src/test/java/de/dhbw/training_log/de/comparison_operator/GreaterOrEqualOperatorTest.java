package de.dhbw.training_log.de.comparison_operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.comparison_operator.ComparisonOperator.*;
import static org.junit.jupiter.api.Assertions.*;

public class GreaterOrEqualOperatorTest {

    @Test
    public void returnTrueWhenComparedObjectIsGreater() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(2);
        assertTrue(GREATER_OR_EQUAL.matches(o1, o2));
    }

    @Test
    public void returnTrueWhenComparedObjectIsEqual() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(1);
        assertTrue(GREATER_OR_EQUAL.matches(o1, o2));
    }

    @Test
    public void returnFalseWhenComparedObjectIsLess() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(0);
        assertFalse(GREATER_OR_EQUAL.matches(o1, o2));
    }

}
