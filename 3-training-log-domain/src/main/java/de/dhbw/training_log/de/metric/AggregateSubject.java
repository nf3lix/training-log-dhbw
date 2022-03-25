package de.dhbw.training_log.de.metric;

public interface AggregateSubject {

    interface Summable<T> extends AggregateSubject {
        T sum(final T summable);
    }

}
