package de.dhbw.training_log.de.aggregate_function;

public interface AggregateSubject {

    interface Summable<T> extends AggregateSubject {
        T add(final T summable);
    }

    interface Averageable<T> extends Summable<T> {
        T divideBy(final Double divisor);
    }

}
