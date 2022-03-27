package de.dhbw.training_log.de.metric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AggregateAvgTest {

    @Test
    public void avg() {
        final AggregateFunction.AVG<AvgMock> avgFunction = new AggregateFunction.AVG<>();
        final List<AvgMock> list = new ArrayList<>();
        list.add(new AvgMock(3.0));
        list.add(new AvgMock(7.0));
        list.add(new AvgMock(4.0));
        list.add(new AvgMock(6.0));
        final AvgMock avg = avgFunction.compute(list);
        assertEquals(avg.value, 5.0);
    }

    private static class AvgMock implements AggregateSubject.Averageable<AvgMock> {

        private final Double value;
        public AvgMock(Double value) {
            this.value = value;
        }

        @Override
        public AvgMock add(AvgMock summable) {
            return new AvgMock(this.value + summable.value);
        }

        @Override
        public AvgMock divideBy(Double divisor) {
            return new AvgMock(this.value / divisor);
        }
    }

}
