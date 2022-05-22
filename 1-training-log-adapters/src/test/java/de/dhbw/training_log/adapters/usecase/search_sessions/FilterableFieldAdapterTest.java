package de.dhbw.training_log.adapters.usecase.search_sessions;

import de.dhbw.training_log.application.search_sessions.FilterableField;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.training_session_type.SessionType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static de.dhbw.training_log.adapters.usecase.search_sessions.FieldNameHasAdapterMatcher.*;
import static de.dhbw.training_log.adapters.usecase.search_sessions.FilterableFieldAdapter.*;
import static de.dhbw.training_log.de.session.distance.DistanceUnit.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

public class FilterableFieldAdapterTest {

    @Test
    public void adapterContainsEntryForEachFilterableField() {
        final Set<FilterableField> filterableFields = new HashSet<>(Arrays.asList(FilterableField.values()));
        Arrays.stream(FilterableFieldAdapter.values()).forEach(adapter -> {
            filterableFields.remove(adapter.getFilterableField());
        });
        assertEquals(filterableFields.size(), 0);
    }

    @Test
    public void getDistanceInMeters() {
        final double distance1 = DISTANCE.getComparedValue("10 KILOMETERS");
        final double distance2 = DISTANCE.getComparedValue("10 METERS");
        final double distance3 = DISTANCE.getComparedValue("10 MILES");
        assertEquals(distance1, new Distance(10, KILOMETERS).getIn(METERS));
        assertEquals(distance2, new Distance(10, METERS).getIn(METERS));
        assertEquals(distance3, new Distance(10, MILES).getIn(METERS));
    }

    @Test
    public void getSessionTypeAsOrdinal() {
        for(final SessionType type : SessionType.values()) {
            assertEquals(SESSION_TYPE.getComparedValue(type.name()), type.ordinal());
        }
    }

    @Test
    public void getSessionTimeInSeconds() {
        assertEquals(SESSION_TIME.getComparedValue("10:01"), 601);
    }

    @Test
    public void getSessionDateAsTimestamp() {
        assertEquals(SESSION_DATE.getComparedValue("01.01.2022"), 1640995200000.0);
    }

    @Test
    public void getAdapterFromString() {
        assertThat("Distance", hasAdapter(DISTANCE));
        assertThat("SessionDistance", hasAdapter(DISTANCE));
        assertThat("Session_Distance", hasAdapter(DISTANCE));

        assertThat("SessionTime", hasAdapter(SESSION_TIME));
        assertThat("Time", hasAdapter(SESSION_TIME));
        assertThat("Session_Time", hasAdapter(SESSION_TIME));

        assertThat("SessionDate", hasAdapter(SESSION_DATE));
        assertThat("SessionDate", hasAdapter(SESSION_DATE));
        assertThat("Date", hasAdapter(SESSION_DATE));

        assertThat("Type", hasAdapter(SESSION_TYPE));
        assertThat("SessionType", hasAdapter(SESSION_TYPE));
        assertThat("Session_Type", hasAdapter(SESSION_TYPE));
    }

    @Test
    public void throwExceptionWhenFieldNameIsUnknown() {
        assertThrows(IllegalArgumentException.class, () -> getAdapter("UNKNOWN_FIELD_NAME"));
    }

}
