package de.dhbw.training_log.de.comparison_operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.comparison_operator.ComparisonOperator.*;
import static org.junit.jupiter.api.Assertions.*;

public class LessThanOperatorTest {

    @Test
    public void returnTrueWhenComparedObjectIsLess() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(0);
        final ComparableMock o3 = new ComparableMock(-1);
        assertTrue(LESS_THAN.matches(o1, o2));
        assertTrue(LESS_THAN.matches(o1, o3));
        assertTrue(LESS_THAN.matches(o2, o3));
    }

    @Test
    public void returnFalseWhenComparedObjectIsEqual() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(1);
        assertFalse(LESS_THAN.matches(o1, o2));
    }

    @Test
    public void returnFalseWhenComparedObjectIsGreater() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(2);
        assertFalse(LESS_THAN.matches(o1, o2));
    }

}
