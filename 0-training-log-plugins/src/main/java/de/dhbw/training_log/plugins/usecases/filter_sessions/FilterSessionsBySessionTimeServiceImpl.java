package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.mapper.filter_criteria.SessionTimeFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionTimeFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.application.filter.FilterSessionsService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.plugins.CommandLine;

import java.util.List;

public class FilterSessionsBySessionTimeServiceImpl extends FilterSessionsService<SessionTime> {

    public FilterSessionsBySessionTimeServiceImpl(final SessionRepository repository) {
        super(repository);
    }

    @Override
    protected FilterCriteria<SessionTime> getCriteria() {
        System.out.println("Enter criteria");
        final String input = CommandLine.readLine();
        final SessionTimeFilterCriteria criteria = new SessionTimeFilterCriteria(input);
        return new SessionTimeFilterCriteriaMapper().toDomainModel(criteria);
    }

    @Override
    protected void displayFilteredSessions(List<Session> sessions) {
        final SessionEntityMapper mapper = new SessionEntityMapper();
        for(Session session : sessions) {
            System.out.println(mapper.toResource(session));
        }
    }

}
