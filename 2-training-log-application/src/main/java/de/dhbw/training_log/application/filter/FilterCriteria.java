package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;
import de.dhbw.training_log.de.session.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FilterCriteria<T extends Comparable<T>> {

    private final Function<? super Session, ? extends T> mapper;
    private final ComparisonOperator operator;
    private final T comparedObject;

    public FilterCriteria(
            final Function<? super Session, ? extends T> mapper,
            final ComparisonOperator operator,
            final T comparedObject) {
        this.mapper = mapper;
        this.operator = operator;
        this.comparedObject = comparedObject;
    }

    public List<Session> apply(final List<Session> sessionList) {
        final List<Session> resultList = new ArrayList<>();
        for(Session currentSession : sessionList) {
            final T currentObject = mapper.apply(currentSession);
            if(operator.matches(comparedObject, currentObject)) {
                resultList.add(currentSession);
            }
        }
        return resultList;
    }

}
