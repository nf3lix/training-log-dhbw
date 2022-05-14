package de.dhbw.training_log.de.comparison_operator;

import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.comparison_operator.ComparisonOperator.GREATER_THAN;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreaterThanOperatorTest {

    @Test
    public void returnTrueWhenComparedObjectIsGreater() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(2);
        assertTrue(GREATER_THAN.matches(o1, o2));
    }

    @Test
    public void returnFalseWhenComparedObjectIsEqual() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(1);
        assertFalse(GREATER_THAN.matches(o1, o2));
    }

    @Test
    public void returnFalseWhenComparedObjectIsLess() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(0);
        final ComparableMock o3 = new ComparableMock(-1);
        assertFalse(GREATER_THAN.matches(o1, o2));
        assertFalse(GREATER_THAN.matches(o1, o3));
        assertFalse(GREATER_THAN.matches(o2, o3));
    }

}
