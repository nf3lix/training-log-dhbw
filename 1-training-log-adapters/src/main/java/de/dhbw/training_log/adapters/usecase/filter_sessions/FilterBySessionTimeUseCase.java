package de.dhbw.training_log.adapters.usecase.filter_sessions;

import de.dhbw.training_log.adapters.mapper.filter_criteria.SessionTimeFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionTimeFilterCriteria;
import de.dhbw.training_log.application.crud_training_session.FilterCriteria;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.time.SessionTime;

public class FilterBySessionTimeUseCase extends FilterUseCase<SessionTime> {

    public FilterBySessionTimeUseCase(final SessionRepository repository) {
        super(repository);
    }

    @Override
    FilterCriteria<SessionTime> getFilterCriteria(String input) {
        final SessionTimeFilterCriteria criteria = new SessionTimeFilterCriteria(input);
        return new SessionTimeFilterCriteriaMapper().toDomainModel(criteria);
    }
}
