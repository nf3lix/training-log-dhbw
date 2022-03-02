package de.dhbw.training_log.application_crud_training_session;

import de.dhbw.training_log.application.crud_training_session.TrainingSessionService;
import dhbw.training_log.de.TrainingSession;
import dhbw.training_log.de.TrainingSessionRepository;
import dhbw.training_log.de.description.Description;
import dhbw.training_log.de.distance.Distance;
import dhbw.training_log.de.time.Minutes;
import dhbw.training_log.de.time.Seconds;
import dhbw.training_log.de.time.SessionTime;
import dhbw.training_log.de.training_session_id.TrainingSessionId;
import dhbw.training_log.de.training_session_type.TrainingSessionType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static dhbw.training_log.de.distance.DistanceUnit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrainingSessionServiceTest {

    private final TrainingSessionRepository repository = mock(TrainingSessionRepository.class);

    @Test
    public void createTrainingSession() {
        final TrainingSessionService service = new TrainingSessionService(repository);
        final TrainingSession trainingSession = sampleTrainingSession();
        service.createTrainingSession(trainingSession);
        verify(repository).insert(trainingSession);
    }

    private TrainingSession sampleTrainingSession() {
        return new TrainingSession(
                new TrainingSessionId(UUID.randomUUID()),
                new Distance(10.0, KILOMETERS),
                new SessionTime(new Minutes(50), new Seconds(20)),
                new Description(""),
                TrainingSessionType.INTERVALS
        );
    }

}
