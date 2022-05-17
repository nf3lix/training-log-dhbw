package de.dhbw.training_log.adapters.usecase.crud;

import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.application.crud_training_session.SessionService;
import de.dhbw.training_log.de.session.SessionRepository;

import java.util.ArrayList;
import java.util.List;

public class ReadSessionsUseCase {

    private final SessionService service;
    private final SessionRepository repository;

    public ReadSessionsUseCase(final SessionRepository repository) {
        this.repository = repository;
        this.service = new SessionService(repository);
    }

    public List<SessionResource> getSessions() {
        final List<SessionResource> resourceList = new ArrayList<>();
        final SessionEntityMapper mapper = new SessionEntityMapper();
        this.service.getSessions().forEach(
                session -> resourceList.add(mapper.toResource(session))
        );
        return resourceList;
    }

}
