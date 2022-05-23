package de.dhbw.training_log.adapters.usecase.crud_session;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.application.crud_training_session.SessionService;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;

public class UpdateSessionUseCase {

    private final SessionService service;

    public UpdateSessionUseCase(final SessionRepository repository) {
        this.service = new SessionService(repository);
    }

    public void updateSession(final SessionResource resource) {
        final Session session = new SessionEntityMapper().toDomainModel(resource);
        this.service.updateSession(session);
    }

}
