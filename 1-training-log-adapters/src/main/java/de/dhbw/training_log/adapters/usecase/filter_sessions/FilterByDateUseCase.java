package de.dhbw.training_log.adapters.usecase.filter_sessions;

import de.dhbw.training_log.adapters.mapper.filter_criteria.SessionDateFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.SessionDateFilterCriteria;
import de.dhbw.training_log.application.crud_training_session.FilterCriteria;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.session_date.SessionDate;

public class FilterByDateUseCase extends FilterUseCase<SessionDate> {

    public FilterByDateUseCase(SessionRepository repository) {
        super(repository);
    }

    @Override
    FilterCriteria<SessionDate> getFilterCriteria(String input) {
        final SessionDateFilterCriteria criteria = new SessionDateFilterCriteria(input);
        return new SessionDateFilterCriteriaMapper().toDomainModel(criteria);
    }

}
