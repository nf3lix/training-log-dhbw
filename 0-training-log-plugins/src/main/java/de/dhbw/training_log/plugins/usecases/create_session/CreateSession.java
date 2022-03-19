package de.dhbw.training_log.plugins.usecases.create_session;

import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;
import dhbw.training_log.de.SessionRepository;

public class CreateSession extends UseCaseInitializer {

    @Override
    public void init(final SessionRepository repository) {
        final CreateSessionServiceImpl service = new CreateSessionServiceImpl(repository);
        service.run();
    }

}
