package de.dhbw.training_log.application.report.standard_metrics;

import de.dhbw.training_log.application.report.ReportService;
import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportServiceTest {

    @Test
    public void reportContainsAllStandardMetrics() {
        final SessionRepository repository = mock(SessionRepository.class);
        final List<Session> sessionList = sessionMocks();
        when(repository.getAll()).thenReturn(sessionList);
        final ReportService reportService = new ReportService(repository);
        final List<Metric.MetricResult> results = reportService.getResults();
        final List<String> resultMetricNames = results.stream().map(Metric.MetricResult::name).collect(Collectors.toList());
        for(Metric metric : StandardMetrics.all()) {
            final String standardMetricName = metric.compute(sessionMocks()).name();
            assertTrue(resultMetricNames.contains(standardMetricName));
        }
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
