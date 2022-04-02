package de.dhbw.training_log.de.aggregate_function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AggregateSumTest {

    @Test
    public void sum() {
        final AggregateFunction.SUM<SummableMock> sum = new AggregateFunction.SUM<>();
        final List<SummableMock> summables = new ArrayList<>();
        summables.add(new SummableMock(3));
        summables.add(new SummableMock(5));
        summables.add(new SummableMock(10));
        final SummableMock all = sum.compute(summables);
        assertEquals(all.value, 18);
    }

    @Test
    public void throwExceptionOnEmptyList() {
        final AggregateFunction.SUM<SummableMock> sum = new AggregateFunction.SUM<>();
        final List<SummableMock> summables = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> sum.compute(summables));
    }

    private static class SummableMock implements AggregateSubject.Summable<SummableMock> {
        private final Integer value;
        SummableMock(final Integer value) {
            this.value = value;
        }

        @Override
        public SummableMock add(SummableMock summable) {
            return new SummableMock(this.value + summable.value);
        }
    }

}
