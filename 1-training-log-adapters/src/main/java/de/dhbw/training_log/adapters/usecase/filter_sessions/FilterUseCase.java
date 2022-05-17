package de.dhbw.training_log.adapters.usecase.filter_sessions;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.application.crud_training_session.SessionService;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class FilterUseCase<T extends Comparable<T>> {

    private final SessionService service;

    public FilterUseCase(final SessionRepository repository) {
        this.service = new SessionService(repository);
    }

    public List<SessionResource> getFilteredSessions(final String criteriaInput) {
        final FilterCriteria<T> criteria = getFilterCriteria(criteriaInput);
        return getFilteredList(criteria);
    }

    abstract FilterCriteria<T> getFilterCriteria(String input);

    private List<SessionResource> getFilteredList(final FilterCriteria<T> filterCriteria) {
        final List<Session> filteredSessions = service.getSessions(filterCriteria);
        final SessionEntityMapper mapper = new SessionEntityMapper();
        return filteredSessions.stream().map(mapper::toResource).collect(Collectors.toList());
    }

}
