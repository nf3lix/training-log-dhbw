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
import org.mockito.ArgumentCaptor;

import java.util.UUID;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateSessionServiceTest {

    private final SessionRepository repository = mock(SessionRepository.class);
    private final CreateSessionService service = new CreateSessionService(repository) {
        protected Distance askForDistance() { return new Distance(10.0, KILOMETERS); }
        protected SessionDate askForSessionDate() { return new SessionDate(new Year(2020), new Month(1), new DayOfMonth(1)); }
        protected SessionTime askForSessionTime() { return new SessionTime(new Minutes(45), new Seconds(30)); }
        protected SessionType askForSessionType() { return SessionType.OTHER; }
        protected Description askForDescription() { return new Description("DESCRIPTION"); }
    };

    @Test
    public void createTrainingSession() {
        when(repository.nextId()).thenReturn(new SessionId(UUID.fromString("af2f909b-50cb-4fc5-aceb-c9fdc4699c27")));
        ArgumentCaptor<Session> session = ArgumentCaptor.forClass(Session.class);
        service.run();
        verify(repository).insert(session.capture());
        assertEquals(session.getValue().id(), new SessionId(UUID.fromString("af2f909b-50cb-4fc5-aceb-c9fdc4699c27")));
        assertEquals(session.getValue().distance(), new Distance(10.0, KILOMETERS));
        assertEquals(session.getValue().time(), new SessionTime(new Minutes(45), new Seconds(30)));
        assertEquals(session.getValue().description(), new Description("DESCRIPTION"));
        assertEquals(session.getValue().type(), SessionType.OTHER);
    }

}
