package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.mapper.filter_criteria.SessionDateFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionDateFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.application.filter.FilterSessionsService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.plugins.CommandLine;

import java.util.List;

public class FilterSessionsByDateServiceImpl extends FilterSessionsService<SessionDate> {

    public FilterSessionsByDateServiceImpl(SessionRepository repository) {
        super(repository);
    }

    @Override
    protected FilterCriteria<SessionDate> getCriteria() {
        System.out.println("Enter criteria");
        final String input = CommandLine.readLine();
        final SessionDateFilterCriteria criteria = new SessionDateFilterCriteria(input);
        return new SessionDateFilterCriteriaMapper().toDomainModel(criteria);
    }

    @Override
    protected void displayFilteredSessions(List<Session> sessions) {
        final SessionEntityMapper mapper = new SessionEntityMapper();
        for(Session session : sessions) {
            System.out.println(mapper.toResource(session));
        }
    }

}
