package de.dhbw.training_log.adapters.usecase.filter_sessions;

import de.dhbw.training_log.adapters.mapper.filter_criteria.DistanceFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.DistanceFilterCriteria;
import de.dhbw.training_log.application.crud_training_session.FilterCriteria;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.distance.Distance;

public class FilterByDistanceUseCase extends FilterUseCase<Distance> {

    public FilterByDistanceUseCase(final SessionRepository repository) {
        super(repository);
    }

    @Override
    FilterCriteria<Distance> getFilterCriteria(String input) {
        final DistanceFilterCriteria criteria = new DistanceFilterCriteria(input);
        return new DistanceFilterCriteriaMapper().toDomainModel(criteria);
    }

}
