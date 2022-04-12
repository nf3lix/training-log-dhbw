package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class FilterSessionsServiceTest {

    @Test
    public void displayFilteredSessionsOnServiceConstruction() {
        final SessionRepository repository = mock(SessionRepository.class);
        final List<Session> sessionList = new ArrayList<>();
        final List<Session> filteredList = new ArrayList<>();
        final Session session1 = sessionMockWithDistance(new Distance(10.0, DistanceUnit.KILOMETERS));
        final Session session2 = sessionMockWithDistance(new Distance(11.0, DistanceUnit.KILOMETERS));
        sessionList.add(sessionMockWithDistance(new Distance(9.0, DistanceUnit.KILOMETERS)));
        sessionList.add(session1);
        sessionList.add(session2);
        filteredList.add(session1);
        filteredList.add(session2);
        when(repository.getAll()).thenReturn(sessionList.iterator());
        final FilterSessionsServiceMock service = new FilterSessionsServiceMock(repository);
        spy(service).getCriteria();
        spy(service).displayFilteredSessions(filteredList);
    }

    private Session sessionMockWithDistance(final Distance distance) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        return session;
    }

    private static class FilterSessionsServiceMock extends FilterSessionsService {

        public FilterSessionsServiceMock(final SessionRepository repository) {
            super(repository);
        }

        @Override
        protected List<FilterCriteria<?>> getCriteria() {
            final FilterCriteria<Distance> criteria = new FilterCriteria<>(Session::distance,
                    ComparisonOperator.GREATER_OR_EQUAL, new Distance(10.0, DistanceUnit.KILOMETERS));
            final ArrayList<FilterCriteria<?>> filterCriteria = new ArrayList<>();
            filterCriteria.add(criteria);
            return filterCriteria;
        }

        @Override
        protected void displayFilteredSessions(List<Session> sessions) {

        }
    }

}
