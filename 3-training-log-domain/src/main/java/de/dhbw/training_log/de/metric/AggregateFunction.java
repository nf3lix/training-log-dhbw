package de.dhbw.training_log.de.metric;

import java.util.Iterator;
import java.util.List;

import static de.dhbw.training_log.de.metric.AggregateSubject.Summable;

public abstract class AggregateFunction<T> {

    public abstract T apply(final List<T> list);

    public static class SUM<T extends Summable<T>> extends AggregateFunction<T> {
        @Override
        public T apply(List<T> list) {
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

}
