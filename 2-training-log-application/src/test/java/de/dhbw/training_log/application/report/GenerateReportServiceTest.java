package de.dhbw.training_log.application.report;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.*;
import static org.mockito.Mockito.*;

public class GenerateReportServiceTest {

    @Test
    public void fetchAllSessionsWhenGeneratingReport() {
        final SessionRepository repository = mock(SessionRepository.class);
        final List<Session> allSessions = new ArrayList<>();
        allSessions.add(sessionMock());
        allSessions.add(sessionMock());
        allSessions.add(sessionMock());
        when(repository.getAll()).thenReturn(allSessions.iterator());
        final GenerateReportService service = new GenerateReportService(repository);
        service.generate();
        verify(repository).getAll();
    }

    private Session sessionMock() {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(new Distance(10.0, METERS));
        when(session.time()).thenReturn(new SessionTime(new Minutes(10), new Seconds(10)));
        return session;
    }

}
