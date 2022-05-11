package de.dhbw.training_log.plugins.usecases.filter_sessions;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;

public class FilterSessionsBySessionTime extends UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        new FilterSessionsBySessionTimeServiceImpl(repository).run();
    }

}
