package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.de.session.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionResourceTest {

    @Test
    public void toCsvLine() {
        final SessionResource resource = new SessionResource(
                UUID.fromString("569e2f72-f0f6-4a88-b701-af38e948742b"),
                new SessionDateResource("01.01.2020"),
                new DistanceResource("10 KILOMETERS"),
                new SessionTimeResource("46:00"),
                "DESCRIPTION",
                SessionType.INTERVALS
        );
        final String[] line = resource.toCsvLine();
        assertEquals(line[0], "569e2f72-f0f6-4a88-b701-af38e948742b");
        assertEquals(line[1], "01.01.2020");
        assertEquals(line[2], "10.0 KILOMETERS");
        assertEquals(line[3], "46:00");
        assertEquals(line[4], "DESCRIPTION");
        assertEquals(line[5], SessionType.INTERVALS.name());
    }

    @Test
    public void toStringTest() {
        final SessionResource resource = sessionResourceWithId("569e2f72-f0f6-4a88-b701-af38e948742b");
        final String resourceString = resource.toString();
        assertEquals(resourceString,
                resource.id().toString() + " - " +
                      resource.sessionDate().toString() + " - " +
                      resource.distance().toString() + " - " +
                      resource.sessionTime().toString() + " - " +
                      resource.description() + " - " +
                      resource.type().name());
    }

    private SessionResource sessionResourceWithId(final String id) {
        return new SessionResource(
                UUID.fromString(id),
                new SessionDateResource("01.01.2020"),
                new DistanceResource("10 KILOMETERS"),
                new SessionTimeResource("46:00"),
                "DESCRIPTION",
                SessionType.INTERVALS
        );
    }

}
