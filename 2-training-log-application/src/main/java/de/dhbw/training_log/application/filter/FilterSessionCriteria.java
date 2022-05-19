package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;
import de.dhbw.training_log.de.session.Session;

import java.util.ArrayList;
import java.util.List;

public class FilterSessionCriteria {

    private final FilterableField field;
    private final ComparisonOperator comparisonOperator;
    private final double comparedValue;

    public FilterSessionCriteria(FilterableField field, ComparisonOperator comparisonOperator, double comparedValue) {
        this.field = field;
        this.comparisonOperator = comparisonOperator;
        this.comparedValue = comparedValue;
    }

    public List<Session> apply(final List<Session> sessionList) {
        final List<Session> resultList = new ArrayList<>();
        for(Session currentSession : sessionList) {
            final double fieldValue = field.mapper().apply(currentSession);
            if(comparisonOperator.matches(comparedValue, fieldValue)) {
                resultList.add(currentSession);
            }
        }
        return resultList;
    }

}
