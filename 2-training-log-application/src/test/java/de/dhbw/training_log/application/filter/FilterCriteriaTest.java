package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.comparison_operator.ComparisonOperator;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterCriteriaTest {

    @Test
    public void filterMatchingSessions() {
        final Distance distance = new Distance(10.0, KILOMETERS);
        final FilterCriteria<Distance> d = new FilterCriteria<>(Session::distance, ComparisonOperator.GREATER_OR_EQUAL, distance);
        final ArrayList<Session> sessions = new ArrayList<>();
        sessions.add(sessionMockWithDistance(new Distance(9.0, KILOMETERS)));
        sessions.add(sessionMockWithDistance(new Distance(10.0, KILOMETERS)));
        sessions.add(sessionMockWithDistance(new Distance(11.0, KILOMETERS)));
        final List<Session> filteredSessions = d.apply(sessions);
        assertEquals(filteredSessions.size(), 2);
        assertEquals(filteredSessions.get(0).distance(), new Distance(10.0, KILOMETERS));
        assertEquals(filteredSessions.get(1).distance(), new Distance(11.0, KILOMETERS));
    }

    private Session sessionMockWithDistance(final Distance distance) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        return session;
    }

}
