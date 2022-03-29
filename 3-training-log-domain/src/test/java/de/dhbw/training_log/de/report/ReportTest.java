package de.dhbw.training_log.de.report;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.metric.StandardMetrics;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import de.dhbw.training_log.de.session.training_session_type.SessionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static de.dhbw.training_log.de.metric.StandardMetrics.*;
import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;

public class ReportTest {

    @Test
    public void buildReport() {
        final Report.ReportBuilder builder = new Report.ReportBuilder();
        final List<Session> sessionList = new ArrayList<>();
        sessionList.add(sessionWithId("569e2f72-f0f6-4a88-b701-af38e948742b"));
        sessionList.add(sessionWithId("af2f909b-50cb-4fc5-aceb-c9fdc4699c27"));
        final Report report = builder
                .setSessionList(sessionList)
                .addMetric(new MaxDistanceMetric())
                .build();
        final List<Metric.MetricResult> results = report.generate();
        Assertions.assertEquals(results.size(), 1);
    }

    private Session sessionWithId(final String uuid) {
        return new Session(
                new SessionId(UUID.fromString(uuid)),
                new SessionDate(new SessionDate.Year(2020), new SessionDate.Month(1), new SessionDate.DayOfMonth(1)),
                new Distance(10.0, KILOMETERS),
                new SessionTime(new Minutes(35), new Seconds(30)),
                new Description("DESCRIPTION"),
                SessionType.OTHER);
    }

}
