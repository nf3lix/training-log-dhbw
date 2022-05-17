package de.dhbw.training_log.adapters.usecase.crud;

import de.dhbw.training_log.application.crud_training_session.SessionService;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;

import java.util.UUID;

public class DeleteSessionUseCase {

    private final SessionService service;

    public DeleteSessionUseCase(final SessionRepository repository) {
        this.service = new SessionService(repository);
    }

    public void deleteSession(final String id) {
        service.deleteSession(new SessionId(UUID.fromString(id)));
    }

}
