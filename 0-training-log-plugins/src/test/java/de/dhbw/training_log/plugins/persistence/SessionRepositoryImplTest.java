package de.dhbw.training_log.plugins.persistence;

import de.dhbw.training_log.de.Session;
import de.dhbw.training_log.de.description.Description;
import de.dhbw.training_log.de.distance.Distance;
import de.dhbw.training_log.de.session_date.SessionDate;
import de.dhbw.training_log.de.time.Minutes;
import de.dhbw.training_log.de.time.Seconds;
import de.dhbw.training_log.de.time.SessionTime;
import de.dhbw.training_log.de.training_session_id.SessionId;
import de.dhbw.training_log.de.training_session_type.SessionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static de.dhbw.training_log.de.distance.DistanceUnit.KILOMETERS;
import static de.dhbw.training_log.de.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class SessionRepositoryImplTest {

    private final FileManipulator fileManipulator = mock(FileManipulator.class);

    @BeforeEach
    void setupFileManipulator() throws IOException {
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(sessionWithId("af2f909b-50cb-4fc5-aceb-c9fdc4699c27"));
        when(fileManipulator.readSessions()).thenReturn(sessionList);
    }

    @Test
    public void loadListOnConstruction() {
        final SessionRepositoryImpl repository = new SessionRepositoryImpl(fileManipulator);
        final Iterator<Session> allSessions = repository.getAll();
        assertEquals(allSessions.next().id().uuid().toString(), "af2f909b-50cb-4fc5-aceb-c9fdc4699c27");
        assertFalse(allSessions.hasNext());
    }

    @Test
    public void insertSession() throws IOException {
        final SessionRepositoryImpl repository = new SessionRepositoryImpl(fileManipulator);
        final Session newSession = sessionWithId("569e2f72-f0f6-4a88-b701-af38e948742b");
        repository.insert(newSession);
        final Iterator<Session> allSessions = repository.getAll();
        assertEquals(allSessions.next().id().uuid().toString(), "af2f909b-50cb-4fc5-aceb-c9fdc4699c27");
        assertEquals(allSessions.next().id().uuid().toString(), "569e2f72-f0f6-4a88-b701-af38e948742b");
        assertFalse(allSessions.hasNext());
        verify(fileManipulator).addSession(newSession);
    }

    private Session sessionWithId(final String uuid) {
        return new Session(
                new SessionId(UUID.fromString(uuid)),
                new SessionDate(new Year(2020), new Month(1), new DayOfMonth(1)),
                new Distance(10.0, KILOMETERS),
                new SessionTime(new Minutes(35), new Seconds(30)),
                new Description("DESCRIPTION"),
                SessionType.OTHER);
    }

}
