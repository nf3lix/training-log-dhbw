package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.mapper.filter_criteria.SessionDateFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionDateFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

public class FilterSessionsByDate implements UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        new FilterSessionsImpl(repository).run();
    }

    private static class FilterSessionsImpl extends FilterSessionsUseCase<SessionDate> {

        public FilterSessionsImpl(SessionRepository repository) {
            super(repository);
        }

        @Override
        FilterCriteria<SessionDate> parseToFilterCriteria(String input) {
            final SessionDateFilterCriteria criteria = new SessionDateFilterCriteria(input);
            return new SessionDateFilterCriteriaMapper().toDomainModel(criteria);
        }
    }

}
