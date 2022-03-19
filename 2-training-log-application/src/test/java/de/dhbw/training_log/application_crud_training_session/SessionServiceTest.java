package de.dhbw.training_log.application_crud_training_session;

import de.dhbw.training_log.application.crud_training_session.SessionService;
import dhbw.training_log.de.Session;
import dhbw.training_log.de.SessionRepository;
import dhbw.training_log.de.description.Description;
import dhbw.training_log.de.distance.Distance;
import dhbw.training_log.de.time.Minutes;
import dhbw.training_log.de.time.Seconds;
import dhbw.training_log.de.time.SessionTime;
import dhbw.training_log.de.training_session_id.SessionId;
import dhbw.training_log.de.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static dhbw.training_log.de.distance.DistanceUnit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SessionServiceTest {

    private final SessionRepository repository = mock(SessionRepository.class);

    @Test
    public void createTrainingSession() {
        final SessionService service = new SessionService(repository);
        final Session trainingSession = sampleTrainingSession();
        service.createTrainingSession(trainingSession);
        verify(repository).insert(trainingSession);
    }

    private Session sampleTrainingSession() {
        return new Session(
                new SessionId(UUID.fromString("af2f909b-50cb-4fc5-aceb-c9fdc4699c27")),
                new Distance(10.0, KILOMETERS),
                new SessionTime(new Minutes(50), new Seconds(20)),
                new Description(""),
                SessionType.INTERVALS
        );
    }

}
