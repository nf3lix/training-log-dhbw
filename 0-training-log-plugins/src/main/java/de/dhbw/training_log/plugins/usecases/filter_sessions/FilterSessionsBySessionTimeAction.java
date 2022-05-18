package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.adapters.usecase.filter_sessions.FilterBySessionTimeUseCase;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.usecases.UserAction;

import java.util.List;

public class FilterSessionsBySessionTimeAction implements UserAction {

    private final FilterBySessionTimeUseCase service;

    public FilterSessionsBySessionTimeAction(final SessionRepository repository) {
        this.service = new FilterBySessionTimeUseCase(repository);
    }

    @Override
    public void initialize() {
        final String filterCriteria = CommandLine.readLine();
        final List<SessionResource> resourceList = service.getFilteredSessions(filterCriteria);
        resourceList.forEach(System.out::println);
    }

    @Override
    public String getDescription() {
        return "Filter sessions by time";
    }

}
