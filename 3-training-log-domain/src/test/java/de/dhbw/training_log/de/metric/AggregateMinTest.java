package de.dhbw.training_log.de.metric;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AggregateMinTest {

    @Test
    public void determineMinFromUniqueItems() {
        final AggregateFunction.MIN<ComparableMock> min = new AggregateFunction.MIN<>();
        final List<ComparableMock> comparableList = new ArrayList<>();
        comparableList.add(new ComparableMock(10));
        comparableList.add(new ComparableMock(3));
        comparableList.add(new ComparableMock(4));
        final ComparableMock comparable = min.compute(comparableList);
        assertEquals(comparable.value, 3);
    }

    @Test
    public void determineMinFromMultipleIdentical() {
        final AggregateFunction.MIN<ComparableMock> min = new AggregateFunction.MIN<>();
        final List<ComparableMock> comparableList = new ArrayList<>();
        comparableList.add(new ComparableMock(3));
        comparableList.add(new ComparableMock(3));
        comparableList.add(new ComparableMock(3));
        final ComparableMock comparable = min.compute(comparableList);
        assertEquals(comparable.value, 3);
    }

    @Test
    public void determineMinPositiveAndNegativeItems() {
        final AggregateFunction.MIN<ComparableMock> min = new AggregateFunction.MIN<>();
        final List<ComparableMock> comparableList = new ArrayList<>();
        comparableList.add(new ComparableMock(-3));
        comparableList.add(new ComparableMock(3));
        final ComparableMock comparable = min.compute(comparableList);
        assertEquals(comparable.value, -3);
    }

    private static class ComparableMock implements Comparable<ComparableMock> {
        private final Integer value;
        public ComparableMock(final Integer value) {
            this.value = value;
        }

        @Override
        public int compareTo(ComparableMock o) {
            return this.value - o.value;
        }
    }

}
