package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.application.filter.FilterSessionsService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.List;

public class FilterSessionsServiceImp extends FilterSessionsService {

    public FilterSessionsServiceImp(final SessionRepository repository) {
        super(repository);
    }

    @Override
    protected List<FilterCriteria<?>> getCriteria() {
        return null;
    }

    @Override
    protected void displayFilteredSessions(final List<Session> sessions) {

    }

}
