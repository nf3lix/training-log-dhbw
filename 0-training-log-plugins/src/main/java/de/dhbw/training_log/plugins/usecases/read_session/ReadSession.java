package de.dhbw.training_log.plugins.usecases.read_session;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.application.crud_training_session.ReadSessionService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

public class ReadSession extends ReadSessionService {

    public ReadSession(final SessionRepository repository) {
        super(repository);
    }

    @Override
    protected void displaySession(Session session) {
        System.out.println(sessionAsString(session));
    }

    private String sessionAsString(final Session session) {
        final SessionResource resource = new SessionEntityMapper().toResource(session);
        return resource.toString();
    }

}
