package de.dhbw.training_log.application.search_sessions;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchSessionsService {

    private final SessionRepository repository;

    public SearchSessionsService(final SessionRepository repository) {
        this.repository = repository;
    }

    public List<Session> getFilteredSessions(final List<FilterCriteria> criteriaList) {
        List<Session> filteredList = new ArrayList<>(repository.getAll());
        for(FilterCriteria criteria : criteriaList) {
            filteredList = criteria.apply(filteredList);
        }
        return filteredList;
    }

}
