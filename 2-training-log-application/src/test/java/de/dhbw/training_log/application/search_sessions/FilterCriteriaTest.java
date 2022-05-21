package de.dhbw.training_log.application.search_sessions;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dhbw.training_log.application.search_sessions.FilterableField.DISTANCE;
import static de.dhbw.training_log.de.comparison_operator.ComparisonOperator.EQUAL_TO;
import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FilterCriteriaTest {

    @Test
    public void applyDistanceFilterCriteria() {
        final FilterCriteria filterCriteria = new FilterCriteria(DISTANCE, EQUAL_TO, 10000);
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(sessionWithDistance(new Distance(12, KILOMETERS)));
        sessionList.add(sessionWithDistance(new Distance(10, KILOMETERS)));
        sessionList.add(sessionWithDistance(new Distance(9, KILOMETERS)));
        sessionList.add(sessionWithDistance(new Distance(10, KILOMETERS)));
        final List<Session> resultList = filterCriteria.apply(sessionList);
        assertEquals(resultList.size(), 2);
        assertEquals(resultList.get(0).distance(), new Distance(10, KILOMETERS));
        assertEquals(resultList.get(1).distance(), new Distance(10, KILOMETERS));
    }

    private Session sessionWithDistance(final Distance distance) {
        final Session session = mock(Session.class);
        when(session.distance()).thenReturn(distance);
        return session;
    }

}
