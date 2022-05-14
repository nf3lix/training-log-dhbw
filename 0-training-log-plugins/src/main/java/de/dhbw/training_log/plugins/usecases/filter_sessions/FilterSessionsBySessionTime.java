package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.mapper.filter_criteria.SessionTimeFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionTimeFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

public class FilterSessionsBySessionTime implements UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        new FilterSessionsImpl(repository).run();
    }

    private static class FilterSessionsImpl extends FilterSessionsUseCase<SessionTime> {

        public FilterSessionsImpl(SessionRepository repository) {
            super(repository);
        }

        @Override
        FilterCriteria<SessionTime> parseToFilterCriteria(String input) {
            final SessionTimeFilterCriteria criteria = new SessionTimeFilterCriteria(input);
            return new SessionTimeFilterCriteriaMapper().toDomainModel(criteria);
        }
    }

}
