package de.dhbw.training_log.application.crud_training_session;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import de.dhbw.training_log.de.session.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.mockito.Mockito.*;

public class ReadSessionServiceTest {

    private final SessionRepository repository = mock(SessionRepository.class);
    private final ReadSessionService service = new ReadSessionService(repository) {
        @Override protected void displaySession(Session session) { }
    };

    @Test
    public void displayEachSessionInRepository() {
        final List<Session> sessionList = new ArrayList<>();
        final Session session1 = mock(Session.class);
        final Session session2 = mock(Session.class);
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
