package de.dhbw.training_log.plugins.persistence;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionRepositoryImplTest {

    @Test
    public void getAllSessions() {
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(mock(Session.class));
        sessionList.add(mock(Session.class));
        final SessionRepositoryImpl sessionRepository = new SessionRepositoryImpl(sessionList);
        assertEquals(sessionRepository.getAll().size(), 2);
    }

    @Test
    public void deleteSession() {
        final List<Session> sessionList = new ArrayList<>();
        final Session session = mock(Session.class);
        when(session.id()).thenReturn(new SessionId(UUID.fromString("faa6361b-2587-4e24-a870-64b6e9c26a37")));
        sessionList.add(session);
        final SessionRepositoryImpl sessionRepository = new SessionRepositoryImpl(sessionList);
        sessionRepository.delete(new SessionId(UUID.fromString("faa6361b-2587-4e24-a870-64b6e9c26a37")));
        assertEquals(sessionRepository.getAll().size(), 0);
    }

    @Test
    public void throwExceptionWhenSessionToDeleteCouldNotBeFound() {
        final List<Session> sessionList = new ArrayList<>();
        final SessionId id = new SessionId(UUID.fromString("faa6361b-2587-4e24-a870-64b6e9c26a37"));
        final SessionRepositoryImpl sessionRepository = new SessionRepositoryImpl(sessionList);
        Assertions.assertThrows(NoSuchElementException.class, () -> sessionRepository.delete(id));
    }

    @Test
    public void addSession() {
        final List<Session> sessionList = new ArrayList<>();
        final SessionRepositoryImpl sessionRepository = new SessionRepositoryImpl(sessionList);
        sessionRepository.insert(mock(Session.class));
        assertEquals(sessionRepository.getAll().size(), 1);
    }

}
