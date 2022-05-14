package de.dhbw.training_log.adapters.mapper.filter_criteria;

import de.dhbw.training_log.adapters.mapper.SessionDateMapper;
import de.dhbw.training_log.adapters.mapper.SessionResourceMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionDateFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.session_date.SessionDate;

public class SessionDateFilterCriteriaMapper implements SessionResourceMapper<SessionDateFilterCriteria, FilterCriteria<SessionDate>> {

    @Override
    public SessionDateFilterCriteria toResource(Object domainModelObject) {
        return null;
    }

    @Override
    public FilterCriteria<SessionDate> toDomainModel(SessionDateFilterCriteria resource) {
        final SessionDate sessionDate = new SessionDateMapper().toDomainModel(resource.getFilterValue());
        return new FilterCriteria<>(Session::date, resource.getComparisonOperator(), sessionDate);
    }

}
