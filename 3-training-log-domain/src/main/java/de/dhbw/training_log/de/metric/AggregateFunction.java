package de.dhbw.training_log.de.metric;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static de.dhbw.training_log.de.metric.AggregateSubject.Summable;

public abstract class AggregateFunction<T> {

    public abstract T compute(final List<T> list);

    public static final class SUM<T extends Summable<T>> extends AggregateFunction<T> {
        @Override
        public T compute(List<T> list) {
            if(list.size() == 0) {
                throw new IllegalArgumentException("List must have at least one item");
            }
            final Iterator<T> iterator = list.iterator();
            T summable = iterator.next();
            while (iterator.hasNext()) {
                summable = summable.sum(iterator.next());
            }
            return summable;
        }
    }

    public static final class MIN<T extends Comparable<T>> extends AggregateFunction<T> {
        @Override
        public T compute(List<T> list) {
            if(list.size() == 0) {
                throw new IllegalArgumentException("List must have at least one item");
            }
            final Iterator<T> iterator = list.iterator();
            T currentMin = iterator.next();
            while (iterator.hasNext()) {
                final T nextItem = iterator.next();
                if(currentMin.compareTo(nextItem) > 0) {
                    currentMin = nextItem;
                }
            }
            return currentMin;
        }
    }

    public static final class MAX<T extends Comparable<T>> extends AggregateFunction<T> {
        @Override
        public T compute(List<T> list) {
            if(list.size() == 0) {
                throw new IllegalArgumentException("List must have at least one item");
            }
            return list.stream().max(Comparable::compareTo).get();
        }
    }

}
