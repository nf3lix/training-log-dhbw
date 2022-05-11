package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterSessionsService<T extends Comparable<T>> {

    private final List<Session> allSessions = new ArrayList<>();
    private final SessionRepository repository;

    public FilterSessionsService(final SessionRepository repository) {
        this.repository = repository;
    }

    public final void run() {
        repository.getAll().forEachRemaining(allSessions::add);
        final List<Session> filteredSessions = getCriteria().apply(allSessions);
        displayFilteredSessions(filteredSessions);
    }

    protected abstract FilterCriteria<T> getCriteria();
    protected abstract void displayFilteredSessions(List<Session> sessions);

}
