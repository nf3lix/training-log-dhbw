package de.dhbw.training_log.de.comparison_operator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.comparison_operator.ComparisonOperator.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotEqualOperatorTest {

    @Test
    public void returnFalseWhenComparedObjectIsEqual() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(1);
        assertFalse(NOT_EQUAL.matches(o1, o2));
    }

    @Test
    public void returnTrueWhenComparedObjectIsNotEqual() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(0);
        final ComparableMock o3 = new ComparableMock(-1);
        assertTrue(NOT_EQUAL.matches(o1, o2));
        assertTrue(NOT_EQUAL.matches(o1, o3));
    }

}
