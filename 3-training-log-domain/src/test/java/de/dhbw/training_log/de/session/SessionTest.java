package de.dhbw.training_log.de.session;

import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_id.SessionId;
import de.dhbw.training_log.de.session.training_session_type.SessionType;
import de.dhbw.training_log.de.test_utils.ValueObjectBehaviorTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SessionTest {

    @Test
    public void testSessionEquality() {
        final List<Supplier<Session>> sessions = Arrays.asList(
                () -> sessionWithId("569e2f72-f0f6-4a88-b701-af38e948742b"),
                () -> sessionWithId("d069e2cf-d02b-4d51-ac50-2946ae88c540"),
                () -> sessionWithId("f9b04681-965f-4be9-a184-4e627fc14208")
        );
        ValueObjectBehaviorTest.performValueObjectTests(sessions);
    }

    private Session sessionWithId(final String id) {
        return new Session(
                new SessionId(UUID.fromString(id)),
                new SessionDate(new Year(2022), new Month(1), new DayOfMonth(1)),
                new Distance(10, DistanceUnit.KILOMETERS),
                new SessionTime(new Minutes(30), new Seconds(0)),
                new Description("DESCRIPTION"),
                SessionType.OTHER
        );
    }

}
