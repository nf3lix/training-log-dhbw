package de.dhbw.training_log.adapters.usecase.crud_session;

import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReadSessionsUseCaseTest {

    private final List<Session> sessionMockList = new ArrayList<>();

    public ReadSessionsUseCaseTest() {
        sessionMockList.add(sessionMockWithId("569e2f72-f0f6-4a88-b701-af38e948742b"));
        sessionMockList.add(sessionMockWithId("d069e2cf-d02b-4d51-ac50-2946ae88c540"));
        sessionMockList.add(sessionMockWithId("eaa5773c-67f3-4b33-81b7-ebed40ea926e"));
        sessionMockList.add(sessionMockWithId("faa6361b-2587-4e24-a870-64b6e9c26a37"));
    }

    @Test
    public void getAllAsSessionResource() {
        final ReadSessionsUseCase readSessionsUseCase = new ReadSessionsUseCase(repositoryMock());
        final List<SessionResource> resourceList = readSessionsUseCase.getSessions();
        final List<String> resourceIds = resourceList.stream().map(resource -> resource.id().toString()).collect(Collectors.toList());
        assertEquals(resourceList.size(), sessionMockList.size());
        for(final Session session : sessionMockList) {
            final String sessionUUID = session.id().uuid().toString();
            assertTrue(resourceIds.contains(sessionUUID));
        }
    }

    private SessionRepository repositoryMock() {
        final SessionRepository repository = mock(SessionRepository.class);
        when(repository.getAll()).thenReturn(sessionMockList);
        return repository;
    }

    private Session sessionMockWithId(final String id) {
        final Session session = mock(Session.class);
        when(session.id()).thenReturn(new SessionId(UUID.fromString(id)));
        when(session.distance()).thenReturn(new Distance(10, KILOMETERS));
        when(session.date()).thenReturn(new SessionDate(new Year(2022), new Month(1), new DayOfMonth(1)));
        when(session.time()).thenReturn(new SessionTime(new Minutes(30), new Seconds(0)));
        when(session.description()).thenReturn(new Description("DESCRIPTION"));
        return session;
    }

}
