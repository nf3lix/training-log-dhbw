package de.dhbw.training_log.adapters.usecase.crud_session;

import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeleteSessionUseCaseTest {

    @Test
    public void deleteSessionTest() {
        final SessionRepository repository = mock(SessionRepository.class);
        final String id = "569e2f72-f0f6-4a88-b701-af38e948742b";
        final DeleteSessionUseCase useCase = new DeleteSessionUseCase(repository);
        useCase.deleteSession(id);
        verify(repository).delete(new SessionId(UUID.fromString(id)));
    }

}
