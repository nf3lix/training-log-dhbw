package de.dhbw.training_log.adapters.usecase.filter_sessions;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.adapters.resource.filter_criteria.FilterQueryResource;
import de.dhbw.training_log.adapters.resource.filter_criteria.QueryResource;
import de.dhbw.training_log.application.filter.FilterSessionCriteria;
import de.dhbw.training_log.application.filter.FilterSessionsService;
import de.dhbw.training_log.application.filter.FilterableField;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeFilterUseCase {

    private final FilterSessionsService service;

    public CompositeFilterUseCase(final SessionRepository repository) {
        this.service = new FilterSessionsService(repository);
    }

    public List<SessionResource> getFilteredList(final String searchQuery) {
        final List<Session> sessionList = service.getFilteredSessions(getCriteriaList(searchQuery));
        final SessionEntityMapper mapper = new SessionEntityMapper();
        return sessionList.stream().map(mapper::toResource).collect(Collectors.toList());
    }

    private List<FilterSessionCriteria> getCriteriaList(final String searchQuery) {
        final FilterQueryResource filterQuery = new FilterQueryResource(searchQuery);
        final List<FilterSessionCriteria> criteriaList = new ArrayList<>();
        filterQuery.getQueries().forEach(query -> criteriaList.add(toFilterCriteria(query)));
        return criteriaList;
    }

    private FilterSessionCriteria toFilterCriteria(final QueryResource query) {
        final FilterableFieldAdapter adapter = FilterableFieldAdapter.getAdapter(query.getFieldName());
        final double comparedValue = adapter.getComparedValue(query.getComparedValue());
        final FilterableField filterableField = adapter.getFilterableField();
        return new FilterSessionCriteria(filterableField, query.getComparisonOperator(), comparedValue);
    }

}
