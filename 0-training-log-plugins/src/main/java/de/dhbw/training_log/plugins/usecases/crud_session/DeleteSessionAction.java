package de.dhbw.training_log.plugins.usecases.crud_session;

import de.dhbw.training_log.adapters.usecase.crud_session.DeleteSessionUseCase;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.action.UserAction;

public class DeleteSessionAction implements UserAction {

    private final DeleteSessionUseCase service;

    public DeleteSessionAction(final SessionRepository repository) {
        this.service = new DeleteSessionUseCase(repository);
    }

    @Override
    public void initialize() {
        System.out.println("Enter id of session to delete (example: \"3e35d8b7-2ddf-4a75-9e8c-b45555188109\"");
        final String id = CommandLine.readLine();
        service.deleteSession(id);
    }

    @Override
    public String getDescription() {
        return "Delete training session";
    }

}
