package de.dhbw.training_log.adapters;

import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.adapters.resource.SessionDateResource;
import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.adapters.resource.SessionTimeResource;

import java.util.UUID;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionResourceMock {

    public static SessionResource resourceMockWithId(final String id) {
        final SessionResource sessionResource = mock(SessionResource.class);
        final SessionDateResource sessionDateResource = sessionDateResourceMock();
        final DistanceResource distanceResource = distanceResourceMock();
        final SessionTimeResource sessionTimeResource = sessionTimeResourceMock();

        when(sessionResource.id()).thenReturn(UUID.fromString(id));
        when(sessionResource.sessionDate()).thenReturn(sessionDateResource);
        when(sessionResource.distance()).thenReturn(distanceResource);
        when(sessionResource.sessionTime()).thenReturn(sessionTimeResource);
        return sessionResource;
    }

    private static SessionDateResource sessionDateResourceMock() {
        final SessionDateResource sessionDateResource = mock(SessionDateResource.class);
        when(sessionDateResource.year()).thenReturn(2022);
        when(sessionDateResource.month()).thenReturn(1);
        when(sessionDateResource.day()).thenReturn(1);
        return sessionDateResource;
    }

    private static DistanceResource distanceResourceMock() {
        final DistanceResource distanceResource = mock(DistanceResource.class);
        when(distanceResource.distance()).thenReturn(10.0);
        when(distanceResource.unit()).thenReturn(KILOMETERS);
        return distanceResource;
    }

    private static SessionTimeResource sessionTimeResourceMock() {
        final SessionTimeResource sessionTimeResource = mock(SessionTimeResource.class);
        when(sessionTimeResource.minutes()).thenReturn(30);
        when(sessionTimeResource.seconds()).thenReturn(0);
        return sessionTimeResource;
    }

}
