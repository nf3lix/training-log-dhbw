package de.dhbw.training_log.adapters.usecase.crud_session;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.application.crud_training_session.SessionService;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadSessionsUseCase {

    private final SessionService service;

    public ReadSessionsUseCase(final SessionRepository repository) {
        this.service = new SessionService(repository);
    }

    public List<SessionResource> getSessions() {
        return new SessionEntityMapper().toResourceList(this.service.getSessions());
    }

}
