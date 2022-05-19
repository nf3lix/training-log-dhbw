package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.adapters.usecase.search_sessions.SearchSessionsUseCase;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.action.UserAction;

import java.util.List;

public class SearchSessionsAction implements UserAction {

    private final SearchSessionsUseCase service;

    public SearchSessionsAction(final SessionRepository repository) {
        this.service = new SearchSessionsUseCase(repository);
    }

    @Override
    public void initialize() {
        System.out.println("Enter search query (Example: \"Date>10.01.2022;SessionTime>34:00;Distance>=10 KILOMETERS\")");
        final String query = CommandLine.readLine();
        final List<SessionResource> resourceList = service.getFilteredList(query);
        resourceList.forEach(System.out::println);
    }

    @Override
    public String getDescription() {
        return "Search sessions";
    }

}
