package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.metric.AggregateSubject.Averageable;

import java.util.Iterator;
import java.util.List;

import static de.dhbw.training_log.de.metric.AggregateSubject.Summable;

public abstract class AggregateFunction<T, K> {

    public abstract K compute(final List<T> list);

    public static final class SUM<T extends Summable<T>> extends AggregateFunction<T, T> {
        @Override
        public T compute(List<T> list) {
            if(list.size() == 0) {
                throw new IllegalArgumentException("List must have at least one item");
            }
            return sum(list);
        }

        private T sum(List<T> list) {
            final Iterator<T> iterator = list.iterator();
            T summable = iterator.next();
            while (iterator.hasNext()) {
                summable = summable.add(iterator.next());
            }
            return summable;
        }
    }

    public static final class MIN<T extends Comparable<T>> extends AggregateFunction<T, T> {
        @Override
        public T compute(List<T> list) {
            if(list.size() == 0) {
                throw new IllegalArgumentException("List must have at least one item");
            }
            return list.stream().min(Comparable::compareTo).get();
        }
    }

    public static final class MAX<T extends Comparable<T>> extends AggregateFunction<T, T> {
        @Override
        public T compute(List<T> list) {
            if(list.size() == 0) {
                throw new IllegalArgumentException("List must have at least one item");
            }
            return list.stream().max(Comparable::compareTo).get();
        }
    }

    public static final class AVG<T extends Averageable<T>> extends AggregateFunction<T, T> {
        @Override
        public T compute(List<T> list) {
            final T sum = new SUM<T>().compute(list);
            return sum.divideBy((double) list.size());
        }
    }

    public static final class COUNT<T> extends AggregateFunction<T, Integer> {
        @Override
        public Integer compute(List<T> list) {
            return list.size();
        }
    }

}
