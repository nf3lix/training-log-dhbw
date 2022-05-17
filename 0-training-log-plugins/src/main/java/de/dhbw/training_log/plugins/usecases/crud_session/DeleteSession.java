package de.dhbw.training_log.plugins.usecases.crud_session;

import de.dhbw.training_log.adapters.usecase.crud.DeleteSessionUseCase;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.usecases.UseCase;

public class DeleteSession implements UseCase {

    private final DeleteSessionUseCase service;

    public DeleteSession(final SessionRepository repository) {
        this.service = new DeleteSessionUseCase(repository);
    }

    @Override
    public void initialize() {
        final String id = CommandLine.readLine();
        service.deleteSession(id);
    }

    @Override
    public String getDescription() {
        return "Delete training session";
    }

}
