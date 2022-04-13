package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterSessionsService {

    private List<Session> filteredList = new ArrayList<>();
    private final SessionRepository repository;

    public FilterSessionsService(final SessionRepository repository) {
        this.repository = repository;
    }

    public final void run() {
        repository.getAll().forEachRemaining(session -> filteredList.add(session));
        for(FilterCriteria<?> criteria : getCriteria()) {
            filteredList = criteria.apply(filteredList);
        }
        displayFilteredSessions(filteredList);
    }

    protected abstract List<FilterCriteria<?>> getCriteria();
    protected abstract void displayFilteredSessions(List<Session> sessions);

}
