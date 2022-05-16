package de.dhbw.training_log.plugins.usecases.crud_session;

import de.dhbw.training_log.application.crud_training_session.DeleteSessionService;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import de.dhbw.training_log.plugins.CommandLine;

import java.util.UUID;

public class DeleteSession extends DeleteSessionService {

    private SessionId id;

    public DeleteSession(final SessionRepository repository) {
        super(repository);
    }

    @Override
    protected SessionId askForSessionId() {
        System.out.println("Enter the id of the object to be deleted");
        final String input = CommandLine.readLine();
        id = new SessionId(UUID.fromString(input));
        return id;
    }

    @Override
    protected void confirmDeletion() {
        System.out.println("Deleted session with id " + id.uuid().toString());
    }
}
