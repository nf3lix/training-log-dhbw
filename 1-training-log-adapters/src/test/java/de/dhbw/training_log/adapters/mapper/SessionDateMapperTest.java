package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.SessionDateResource;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import org.junit.jupiter.api.Test;

import static de.dhbw.training_log.de.session.session_date.SessionDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionDateMapperTest {

    private final SessionDateMapper mapper = new SessionDateMapper();

    @Test
    public void mapToResource() {
        final SessionDate sessionDate1 = new SessionDate(new Year(2020), new Month(1), new DayOfMonth(1));
        final SessionDate sessionDate2 = new SessionDate(new Year(2021), new Month(12), new DayOfMonth(31));
        final SessionDateResource resource1 = mapper.toResource(sessionDate1);
        assertEquals(resource1.year(), 2020);
        assertEquals(resource1.month(), 1);
        assertEquals(resource1.day(), 1);
        final SessionDateResource resource2 = mapper.toResource(sessionDate2);
        assertEquals(resource2.year(), 2021);
        assertEquals(resource2.month(), 12);
        assertEquals(resource2.day(), 31);
    }

    @Test
    public void mapToDomainModel() {
        final SessionDateResource resource1 = new SessionDateResource("01.01.2020");
        final SessionDateResource resource2 = new SessionDateResource("31.12.2021");
        final SessionDate sessionDate1 = mapper.toDomainModel(resource1);
        final SessionDate sessionDate2 = mapper.toDomainModel(resource2);
        assertEquals(sessionDate1.year(), new Year(2020));
        assertEquals(sessionDate1.month(), new Month(1));
        assertEquals(sessionDate1.day(), new DayOfMonth(1));
        assertEquals(sessionDate2.year(), new Year(2021));
        assertEquals(sessionDate2.month(), new Month(12));
        assertEquals(sessionDate2.day(), new DayOfMonth(31));
    }

}
