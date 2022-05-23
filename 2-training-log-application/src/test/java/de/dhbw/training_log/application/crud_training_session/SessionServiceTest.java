package de.dhbw.training_log.application.crud_training_session;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class SessionServiceTest {

    final SessionRepository repository = mock(SessionRepository.class);
    final SessionService service = new SessionService(repository);

    @Test
    public void createSessionTest() {
        final Session session = mock(Session.class);
        service.createSession(session);
        verify(repository).insert(session);
    }

    @Test
    public void getSessionsTest() {
        final List<Session> sessionList = new ArrayList<>();
        final Session session = mock(Session.class);
        sessionList.add(session);
        when(repository.getAll()).thenReturn(sessionList);
        Assertions.assertEquals(service.getSessions(), sessionList);
    }

    @Test
    public void deleteSessionTest() {
        final SessionId id = new SessionId(UUID.fromString("f758cb0b-1122-4e19-8761-c3aaf44c557c"));
        service.deleteSession(id);
        verify(repository).delete(id);
    }

    @Test
    public void editSessionTest() {
        final Session session = mock(Session.class);
        service.updateSession(session);
        verify(repository).update(session);
    }

}
