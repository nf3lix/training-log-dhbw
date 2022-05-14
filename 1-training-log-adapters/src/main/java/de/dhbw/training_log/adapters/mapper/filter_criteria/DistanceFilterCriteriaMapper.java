package de.dhbw.training_log.adapters.mapper.filter_criteria;

import de.dhbw.training_log.adapters.mapper.DistanceMapper;
import de.dhbw.training_log.adapters.mapper.SessionResourceMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.DistanceFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;

public class DistanceFilterCriteriaMapper implements SessionResourceMapper<DistanceFilterCriteria, FilterCriteria<Distance>> {

    @Override
    public DistanceFilterCriteria toResource(Object domainModelObject) {
        return null;
    }

    @Override
    public FilterCriteria<Distance> toDomainModel(DistanceFilterCriteria resource) {
        final Distance distance = new DistanceMapper().toDomainModel(resource.getFilterValue());
        return new FilterCriteria<>(Session::distance, resource.getComparisonOperator(), distance);
    }

}
