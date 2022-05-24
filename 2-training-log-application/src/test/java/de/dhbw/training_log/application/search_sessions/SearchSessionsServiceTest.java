package de.dhbw.training_log.application.search_sessions;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class SearchSessionsServiceTest {

    private final List<Session> repositoryReturnedList = new ArrayList<>();
    private final List<Session> criteria1ReturnedList = new ArrayList<>();
    private final List<Session> criteria2ReturnedList = new ArrayList<>();

    public SearchSessionsServiceTest() {
        repositoryReturnedList.add(mock(Session.class));
        repositoryReturnedList.add(mock(Session.class));
        repositoryReturnedList.add(mock(Session.class));
        criteria1ReturnedList.add(mock(Session.class));
        criteria1ReturnedList.add(mock(Session.class));
        criteria2ReturnedList.add(mock(Session.class));
    }

    @Test
    public void applyEachFilterCriteriaToListOfAllSessions() {
        final SearchSessionsService service = new SearchSessionsService(repositoryMock(repositoryReturnedList));
        final List<FilterCriteria> filterCriteriaList = new ArrayList<>();
        final FilterCriteria criteria1 = filterCriteriaMock(criteria1ReturnedList);
        final FilterCriteria criteria2 = filterCriteriaMock(criteria2ReturnedList);
        filterCriteriaList.add(criteria1);
        filterCriteriaList.add(criteria2);
        final List<Session> serviceReturnedList = service.getFilteredSessions(filterCriteriaList);
        verify(criteria1).apply(repositoryReturnedList);
        verify(criteria2).apply(criteria1ReturnedList);
        assertEquals(serviceReturnedList, criteria2ReturnedList);
    }

    private SessionRepository repositoryMock(final List<Session> returnedList) {
        final SessionRepository repository = mock(SessionRepository.class);
        when(repository.getAll()).thenReturn(returnedList);
        return repository;
    }

    private FilterCriteria filterCriteriaMock(final List<Session> returnedList) {
        final FilterCriteria filterCriteria = mock(FilterCriteria.class);
        when(filterCriteria.apply(anyList())).thenReturn(returnedList);
        return filterCriteria;
    }

}
