package de.dhbw.training_log.adapters.usecase.search_sessions;

import de.dhbw.training_log.adapters.SessionResourceMock;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchSessionsUseCaseTest {

    @Test
    public void getFilteredSessionAsResource() {
        final SearchSessionsUseCase useCase = new SearchSessionsUseCase(repositoryMock());
        final List<SessionResource> resourceList = useCase.getFilteredList("Distance>0 KILOMETERS");
        Assertions.assertEquals(resourceList.get(0).id().toString(), "569e2f72-f0f6-4a88-b701-af38e948742b");
    }

    private SessionRepository repositoryMock() {
        final SessionRepository repository = mock(SessionRepository.class);
        List<Session> sessionList = new ArrayList<>();
        sessionList.add(sessionMock());
        when(repository.getAll()).thenReturn(sessionList);
        return repository;
    }

    private Session sessionMock() {
        final Session session = mock(Session.class);
        when(session.id()).thenReturn(new SessionId(UUID.fromString("569e2f72-f0f6-4a88-b701-af38e948742b")));
        when(session.time()).thenReturn(new SessionTime(new Minutes(30), new Seconds(30)));
        when(session.distance()).thenReturn(new Distance(10, DistanceUnit.KILOMETERS));
        when(session.date()).thenReturn(new SessionDate(new SessionDate.Year(2022), new SessionDate.Month(1), new SessionDate.DayOfMonth(1)));
        when(session.description()).thenReturn(new Description("DESCRIPTION"));
        return session;
    }

}
