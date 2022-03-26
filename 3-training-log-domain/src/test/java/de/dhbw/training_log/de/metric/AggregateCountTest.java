package de.dhbw.training_log.de.metric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregateCountTest {

    @Test
    public void count() {
        final AggregateFunction.COUNT<Integer> count = new AggregateFunction.COUNT<>();
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        Assertions.assertEquals(count.compute(list), 3);
    }

}
