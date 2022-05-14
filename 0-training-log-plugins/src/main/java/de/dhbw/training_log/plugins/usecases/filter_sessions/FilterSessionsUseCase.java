package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.application.filter.FilterSessionsService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;

import java.util.List;

public abstract class FilterSessionsUseCase<T extends Comparable<T>> extends FilterSessionsService<T> {

    public FilterSessionsUseCase(final SessionRepository repository) {
        super(repository);
    }

    @Override
    protected FilterCriteria<T> getCriteria() {
        System.out.println("Enter criteria");
        final String input = CommandLine.readLine();
        return parseToFilterCriteria(input);
    }

    @Override
    protected void displayFilteredSessions(List<Session> sessions) {
        final SessionEntityMapper mapper = new SessionEntityMapper();
        for(Session session : sessions) {
            System.out.println(mapper.toResource(session));
        }
    }

    abstract FilterCriteria<T> parseToFilterCriteria(final String input);

}
