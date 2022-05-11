package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.mapper.filter_criteria.DistanceFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.DistanceFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.application.filter.FilterSessionsService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.plugins.CommandLine;

import java.util.List;

public class FilterSessionsByDistanceServiceImpl extends FilterSessionsService<Distance> {

    public FilterSessionsByDistanceServiceImpl(final SessionRepository repository) {
        super(repository);
    }

    @Override
    protected FilterCriteria<Distance> getCriteria() {
        System.out.println("Enter criteria");
        final String input = CommandLine.readLine();
        final DistanceFilterCriteria criteria = new DistanceFilterCriteria(input);
        return new DistanceFilterCriteriaMapper().toDomainModel(criteria);
    }

    @Override
    protected void displayFilteredSessions(List<Session> sessions) {
        final SessionEntityMapper mapper = new SessionEntityMapper();
        for(Session session : sessions) {
            System.out.println(mapper.toResource(session));
        }
    }

}
