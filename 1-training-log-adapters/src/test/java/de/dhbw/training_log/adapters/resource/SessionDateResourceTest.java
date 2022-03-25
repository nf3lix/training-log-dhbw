package de.dhbw.training_log.adapters.resource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionDateResourceTest {

    @Test
    public void assignLocalDate() {
        final SessionDateResource resource = new SessionDateResource("01.01.2020");
        assertEquals(resource.year(), 2020);
        assertEquals(resource.month(), 1);
        assertEquals(resource.day(), 1);
    }

    @Test
    public void toStringTest() {
        final SessionDateResource resource = new SessionDateResource("01.01.2020");
        assertEquals(resource.toString(), "01.01.2020");
    }

}
