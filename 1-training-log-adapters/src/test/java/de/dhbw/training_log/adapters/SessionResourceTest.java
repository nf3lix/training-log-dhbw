package de.dhbw.training_log.adapters;

import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import dhbw.training_log.de.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SessionResourceTest {

    @Test
    public void fromCsvLine() {
        final String csvContent = "569e2f72-f0f6-4a88-b701-af38e948742b;10000.0 METERS;45:00;DESCRIPTION;LONG_RUN";
        final String[] line = csvContent.split(";");
        final SessionResource resource = SessionResource.fromCsvLine(line);
        assertEquals(resource.id().toString(), "569e2f72-f0f6-4a88-b701-af38e948742b");
        assertEquals(resource.distance().toString(), "10000.0 METERS");
        assertEquals(resource.sessionTime().toString(), "45:00");
        assertEquals(resource.description(), "DESCRIPTION");
        assertEquals(resource.type().name(), "LONG_RUN");
    }

    @Test
    public void toCsvLine() {
        final SessionResource resource = new SessionResource(
                UUID.fromString("569e2f72-f0f6-4a88-b701-af38e948742b"),
                new DistanceResource("10 KILOMETERS"),
                new SessionTimeResource("46:00"),
                "DESCRIPTION",
                SessionType.INTERVALS
        );
        final String[] line = resource.toCsvLine();
        assertEquals(line[0], "569e2f72-f0f6-4a88-b701-af38e948742b");
        assertEquals(line[1], "10.0 KILOMETERS");
        assertEquals(line[2], "46:00");
        assertEquals(line[3], "DESCRIPTION");
        assertEquals(line[4], SessionType.INTERVALS.name());
    }

}
