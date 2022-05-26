package de.dhbw.training_log.adapters.usecase.generate_report;

import de.dhbw.training_log.adapters.resource.MetricResultResource;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.application.report.standard_metrics.StandardMetrics;
import de.dhbw.training_log.de.metric.Metric;
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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenerateReportUseCaseTest {

    private final List<Session> sessionMockList = new ArrayList<>();

    public GenerateReportUseCaseTest() {
        sessionMockList.add(sessionMockWithId("569e2f72-f0f6-4a88-b701-af38e948742b"));
        sessionMockList.add(sessionMockWithId("d069e2cf-d02b-4d51-ac50-2946ae88c540"));
        sessionMockList.add(sessionMockWithId("eaa5773c-67f3-4b33-81b7-ebed40ea926e"));
        sessionMockList.add(sessionMockWithId("faa6361b-2587-4e24-a870-64b6e9c26a37"));
    }

    @Test
    public void metricResultResourceContainsAllStandardMetrics() {
        final GenerateReportUseCase useCase = new GenerateReportUseCase(repositoryMock());
        final List<MetricResultResource> resourceList = useCase.getResults();
        final List<String> resultMetricNames = resourceList.stream().map(MetricResultResource::getMetricName).collect(Collectors.toList());
        for(Metric metric : StandardMetrics.all()) {
            final String standardMetricName = metric.compute(sessionMocks()).name();
            assertTrue(resultMetricNames.contains(standardMetricName));
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
        when(session.time()).thenReturn(new SessionTime(new Minutes(30), new Seconds(30)));
        when(session.distance()).thenReturn(new Distance(10, DistanceUnit.KILOMETERS));
        when(session.date()).thenReturn(new SessionDate(new SessionDate.Year(2022), new SessionDate.Month(1), new SessionDate.DayOfMonth(1)));
        return session;
    }

    private List<Session> sessionMocks() {
        final ArrayList<Session> sessions = new ArrayList<>();
        final Session session = mock(Session.class);
        when(session.time()).thenReturn(new SessionTime(new Minutes(30), new Seconds(30)));
        when(session.distance()).thenReturn(new Distance(10, DistanceUnit.KILOMETERS));
        when(session.date()).thenReturn(new SessionDate(new SessionDate.Year(2022), new SessionDate.Month(1), new SessionDate.DayOfMonth(1)));
        sessions.add(session);
        return sessions;
    }

}
