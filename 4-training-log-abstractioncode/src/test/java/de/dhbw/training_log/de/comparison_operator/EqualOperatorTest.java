package de.dhbw.training_log.de.comparison_operator;

import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.comparison_operator.ComparisonOperator.EQUAL_TO;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualOperatorTest {

    @Test
    public void returnTrueWhenObjectsAreEqual() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(1);
        assertTrue(EQUAL_TO.matches(o1, o2));
        assertTrue(EQUAL_TO.matches(o2, o1));
    }

    @Test
    public void returnFalseWhenObjectsAreUnequal() {
        final ComparableMock o1 = new ComparableMock(1);
        final ComparableMock o2 = new ComparableMock(2);
        final ComparableMock o3 = new ComparableMock(-1);
        assertFalse(EQUAL_TO.matches(o1, o2));
        assertFalse(EQUAL_TO.matches(o1, o3));
        assertFalse(EQUAL_TO.matches(o2, o3));
    }

}
