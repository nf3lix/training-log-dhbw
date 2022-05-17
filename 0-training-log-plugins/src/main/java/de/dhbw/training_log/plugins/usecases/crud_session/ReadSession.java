package de.dhbw.training_log.plugins.usecases.crud_session;

import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.adapters.usecase.crud.ReadSessionsUseCase;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.usecases.UseCase;

import java.util.List;

public class ReadSession implements UseCase {

    private final ReadSessionsUseCase service;

    public ReadSession(final SessionRepository repository) {
        this.service = new ReadSessionsUseCase(repository);
    }

    @Override
    public void initialize() {
        final List<SessionResource> resourceList = service.getSessions();
        for(SessionResource resource : resourceList) {
            System.out.println(resource);
        }
    }

    @Override
    public String getDescription() {
        return "Show all training sessions";
    }


}
