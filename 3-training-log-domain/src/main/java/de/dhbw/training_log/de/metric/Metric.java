package de.dhbw.training_log.de.metric;

import java.util.List;

public abstract class Metric<T, K> {

    private final AggregateFunction<T, K> aggregateFunction;

    public Metric(AggregateFunction<T, K> aggregateFunction) {
        this.aggregateFunction = aggregateFunction;
    }

    public final K compute(final List<T> list) {
        return aggregateFunction.compute(list);
    }

}
