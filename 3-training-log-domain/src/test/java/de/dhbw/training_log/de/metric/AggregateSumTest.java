package de.dhbw.training_log.de.metric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregateSumTest {

    @Test
    public void sum() {
        final AggregateFunction.SUM<SummableMock> sum = new AggregateFunction.SUM<>();
        final List<SummableMock> summables = new ArrayList<>();
        summables.add(new SummableMock(3));
        summables.add(new SummableMock(5));
        summables.add(new SummableMock(10));
        final SummableMock all = sum.apply(summables);
        Assertions.assertEquals(all.value, 18);
    }

    private static class SummableMock implements AggregateSubject.Summable<SummableMock> {
        private final Integer value;
        SummableMock(final Integer value) {
            this.value = value;
        }

        @Override
        public SummableMock sum(SummableMock summable) {
            return new SummableMock(this.value + summable.value);
        }
    }

}
