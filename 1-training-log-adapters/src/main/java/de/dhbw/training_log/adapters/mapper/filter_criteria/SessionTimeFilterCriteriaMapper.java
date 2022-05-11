package de.dhbw.training_log.adapters.mapper.filter_criteria;

import de.dhbw.training_log.adapters.mapper.SessionResourceMapper;
import de.dhbw.training_log.adapters.mapper.SessionTimeMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionTimeFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.time.SessionTime;

public class SessionTimeFilterCriteriaMapper implements SessionResourceMapper<SessionTimeFilterCriteria, FilterCriteria<SessionTime>> {

    @Override
    public SessionTimeFilterCriteria toResource(Object domainModelObject) {
        return null;
    }

    @Override
    public FilterCriteria<SessionTime> toDomainModel(SessionTimeFilterCriteria resource) {
        final SessionTime sessionTime = new SessionTimeMapper().toDomainModel(resource.getFilterValue());
        return new FilterCriteria<>(Session::time, resource.getComparisonOperator(), sessionTime);
    }

}
