package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

public class FilterSessionsByDate extends UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        new FilterSessionsByDateServiceImpl(repository).run();
    }

}
