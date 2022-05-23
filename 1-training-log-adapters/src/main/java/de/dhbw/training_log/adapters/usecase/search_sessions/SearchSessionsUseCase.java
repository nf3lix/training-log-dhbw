package de.dhbw.training_log.adapters.usecase.search_sessions;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.application.search_sessions.FilterCriteria;
import de.dhbw.training_log.application.search_sessions.FilterableField;
import de.dhbw.training_log.application.search_sessions.SearchSessionsService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchSessionsUseCase {

    private final SearchSessionsService service;

    public SearchSessionsUseCase(final SessionRepository repository) {
        this.service = new SearchSessionsService(repository);
    }

    public List<SessionResource> getFilteredList(final String searchQuery) {
        final List<Session> sessionList = service.getFilteredSessions(getCriteriaList(searchQuery));
        return new SessionEntityMapper().toResourceList(sessionList);
    }

    private List<FilterCriteria> getCriteriaList(final String searchQuery) {
        final CompositeSearchQuery filterQuery = new CompositeSearchQuery(searchQuery);
        final List<FilterCriteria> criteriaList = new ArrayList<>();
        filterQuery.getQueries().forEach(query -> criteriaList.add(toFilterCriteria(query)));
        return criteriaList;
    }

    private FilterCriteria toFilterCriteria(final SearchQuery query) {
        final FilterableFieldAdapter adapter = FilterableFieldAdapter.getAdapter(query.getFieldName());
        final double comparedValue = adapter.getComparedValue(query.getComparedValue());
        final FilterableField filterableField = adapter.getFilterableField();
        return new FilterCriteria(filterableField, query.getComparisonOperator(), comparedValue);
    }

}
