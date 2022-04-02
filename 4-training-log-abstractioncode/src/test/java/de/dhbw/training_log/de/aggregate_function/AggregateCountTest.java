package de.dhbw.training_log.de.aggregate_function;

import de.dhbw.training_log.de.aggregate_function.AggregateFunction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AggregateCountTest {

    @Test
    public void count() {
        final AggregateFunction.COUNT<Integer> count = new AggregateFunction.COUNT<>();
        final List<Integer> list = new ArrayList<>();
        assertEquals(count.compute(list), 0);
        list.add(1);
        list.add(1);
        list.add(1);
        assertEquals(count.compute(list), 3);
    }

}
