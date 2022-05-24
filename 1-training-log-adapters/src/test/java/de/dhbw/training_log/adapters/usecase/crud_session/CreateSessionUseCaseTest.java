package de.dhbw.training_log.adapters.usecase.crud_session;

import de.dhbw.training_log.adapters.SessionResourceMock;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateSessionUseCaseTest {

    @Test
    public void createSessionFromResource() {
        final SessionRepository repository = mock(SessionRepository.class);
        final CreateSessionUseCase useCase = new CreateSessionUseCase(repository);
        final String id = "569e2f72-f0f6-4a88-b701-af38e948742b";
        final SessionResource sessionResource = SessionResourceMock.resourceMockWithId(id);
        useCase.run(sessionResource);
        final ArgumentCaptor<Session> captor = ArgumentCaptor.forClass(Session.class);
        verify(repository).insert(captor.capture());
        assertEquals(captor.getValue().id().uuid().toString(), id);
    }

}
