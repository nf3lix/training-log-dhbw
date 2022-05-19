package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public class FilterSessionsService {

    private final SessionRepository repository;

    public FilterSessionsService(final SessionRepository repository) {
        this.repository = repository;
    }

    public List<Session> getFilteredSessions(final List<FilterSessionCriteria> criteriaList) {
        List<Session> filteredList = new ArrayList<>(repository.getAll());
        for(FilterSessionCriteria criteria : criteriaList) {
            filteredList = criteria.apply(filteredList);
        }
        return filteredList;
    }

}
