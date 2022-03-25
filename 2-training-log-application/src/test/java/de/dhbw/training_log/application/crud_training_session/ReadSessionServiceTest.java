package de.dhbw.training_log.application.crud_training_session;

import de.dhbw.training_log.de.Session;
import de.dhbw.training_log.de.SessionRepository;
import de.dhbw.training_log.de.description.Description;
import de.dhbw.training_log.de.distance.Distance;
import de.dhbw.training_log.de.session_date.SessionDate;
import de.dhbw.training_log.de.time.Minutes;
import de.dhbw.training_log.de.time.Seconds;
import de.dhbw.training_log.de.time.SessionTime;
import de.dhbw.training_log.de.training_session_id.SessionId;
import de.dhbw.training_log.de.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static de.dhbw.training_log.de.distance.DistanceUnit.KILOMETERS;
import static de.dhbw.training_log.de.session_date.SessionDate.*;
import static org.mockito.Mockito.*;

public class ReadSessionServiceTest {

    private final SessionRepository repository = mock(SessionRepository.class);
    private final ReadSessionService service = new ReadSessionService(repository) {
        @Override protected void displaySession(Session session) { }
    };

    @Test
    public void displayEachSessionInRepository() {
        final List<Session> sessionList = new ArrayList<>();
        final Session session1 = sessionWithId("af2f909b-50cb-4fc5-aceb-c9fdc4699c27");
        final Session session2 = sessionWithId("569e2f72-f0f6-4a88-b701-af38e948742b");
        sessionList.add(session1);
        sessionList.add(session2);
        when(repository.getAll()).thenReturn(sessionList.listIterator());
        service.run();
        verify(repository).getAll();
        spy(service).displaySession(session1);
        spy(service).displaySession(session2);
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
