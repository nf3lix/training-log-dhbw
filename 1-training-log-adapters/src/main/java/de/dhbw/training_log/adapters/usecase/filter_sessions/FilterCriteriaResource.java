package de.dhbw.training_log.adapters.usecase.filter_sessions;

import de.dhbw.training_log.adapters.resource.filter_criteria.QueryResource;
import de.dhbw.training_log.application.filter.FilterableSessionField;
import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;

public class FilterCriteriaResource {

    private final String fieldName;
    private final ComparisonOperator comparisonOperator;
    private final double comparedValue;

    public FilterCriteriaResource(final QueryResource query) {
        this.fieldName = query.getFieldName();
        this.comparisonOperator = query.getComparisonOperator();
        final FilterableSessionField field = FilterableFields.getFilterableField(fieldName);
        this.comparedValue = field.numericalValueFromString(query.getComparedValue());
    }



}
