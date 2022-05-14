package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.adapters.mapper.filter_criteria.DistanceFilterCriteriaMapper;
import de.dhbw.training_log.adapters.resource.filter_criteria.DistanceFilterCriteria;
import de.dhbw.training_log.application.filter.FilterCriteria;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

public class FilterSessionsByDistance extends UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        new FilterSessionsImpl(repository).run();
    }

    private static class FilterSessionsImpl extends FilterSessionsUseCase<Distance> {

        public FilterSessionsImpl(SessionRepository repository) {
            super(repository);
        }

        @Override
        FilterCriteria<Distance> parseToFilterCriteria(String input) {
            final DistanceFilterCriteria criteria = new DistanceFilterCriteria(input);
            return new DistanceFilterCriteriaMapper().toDomainModel(criteria);
        }
    }

}
