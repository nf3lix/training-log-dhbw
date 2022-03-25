package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import de.dhbw.training_log.de.time.Minutes;
import de.dhbw.training_log.de.time.Seconds;
import de.dhbw.training_log.de.time.SessionTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SessionTimeMapperTest {

    private final SessionTimeMapper mapper = new SessionTimeMapper();

    @Test
    public void mapToResource() {
        final SessionTime sessionTime = new SessionTime(new Minutes(30), new Seconds(29));
        final SessionTimeResource resource = mapper.toResource(sessionTime);
        assertEquals(resource.minutes(), 30);
        assertEquals(resource.seconds(), 29);
    }

    @Test
    public void mapToDomainModel() {
        final SessionTimeResource resource1 = new SessionTimeResource("30:29");
        final SessionTime sessionTime1 = mapper.toDomainModel(resource1);
        assertEquals(sessionTime1.minutes(), 30);
        assertEquals(sessionTime1.seconds(), 29);
    }

}
