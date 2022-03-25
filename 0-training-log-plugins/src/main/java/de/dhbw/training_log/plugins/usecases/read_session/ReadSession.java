package de.dhbw.training_log.plugins.usecases.read_session;

import de.dhbw.training_log.plugins.usecases.UseCaseInitializer;
import de.dhbw.training_log.de.session.SessionRepository;

public class ReadSession extends UseCaseInitializer {

    @Override
    public void init(SessionRepository repository) {
        final ReadSessionServiceImpl service = new ReadSessionServiceImpl(repository);
        service.run();
    }

}
