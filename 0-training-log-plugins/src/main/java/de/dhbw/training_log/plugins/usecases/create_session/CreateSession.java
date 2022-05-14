package de.dhbw.training_log.plugins.usecases.create_session;

import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;
import de.dhbw.training_log.de.session.SessionRepository;

public class CreateSession implements UseCaseInitializer {

    @Override
    public void init(final SessionRepository repository) {
        final CreateSessionServiceImpl service = new CreateSessionServiceImpl(repository);
        service.run();
    }

}
