package de.dhbw.training_log.de.metric;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AggregateMaxTest {

    @Test
    public void determineMaxFromUniqueItems() {
        final AggregateFunction.MAX<ComparableMock> min = new AggregateFunction.MAX<>();
        final List<ComparableMock> comparableList = new ArrayList<>();
        comparableList.add(new ComparableMock(10));
        comparableList.add(new ComparableMock(3));
        comparableList.add(new ComparableMock(4));
        final ComparableMock comparable = min.compute(comparableList);
        assertEquals(comparable.value, 10);
    }

    @Test
    public void determineMaxFromMultipleIdentical() {
        final AggregateFunction.MAX<ComparableMock> min = new AggregateFunction.MAX<>();
        final List<ComparableMock> comparableList = new ArrayList<>();
        comparableList.add(new ComparableMock(3));
        comparableList.add(new ComparableMock(3));
        comparableList.add(new ComparableMock(3));
        final ComparableMock comparable = min.compute(comparableList);
        assertEquals(comparable.value, 3);
    }

    @Test
    public void determineMaxPositiveAndNegativeItems() {
        final AggregateFunction.MAX<ComparableMock> max = new AggregateFunction.MAX<>();
        final List<ComparableMock> comparableList = new ArrayList<>();
        comparableList.add(new ComparableMock(-3));
        comparableList.add(new ComparableMock(3));
        final ComparableMock comparable = max.compute(comparableList);
        assertEquals(comparable.value, 3);
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
