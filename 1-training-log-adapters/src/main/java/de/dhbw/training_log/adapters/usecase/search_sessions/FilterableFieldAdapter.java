package de.dhbw.training_log.adapters.usecase.search_sessions;

import de.dhbw.training_log.adapters.mapper.DistanceMapper;
import de.dhbw.training_log.adapters.mapper.SessionDateMapper;
import de.dhbw.training_log.adapters.mapper.SessionTimeMapper;
import de.dhbw.training_log.adapters.mapper.SessionTypeMapper;
import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.adapters.resource.SessionDateResource;
import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import de.dhbw.training_log.application.search_sessions.FilterableField;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.SessionTime;
import de.dhbw.training_log.de.session.training_session_type.SessionType;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public enum FilterableFieldAdapter {

    DISTANCE(FilterableField.DISTANCE, "Distance", "SessionDistance", "SessionDistance") {
        @Override
        public double getComparedValue(final String input) {
            final DistanceResource resource = new DistanceResource(input);
            final Distance distance = new DistanceMapper().toDomainModel(resource);
            return distance.getIn(DistanceUnit.METERS);
        }
    },

    SESSION_TIME(FilterableField.SESSION_TIME, "SessionTime", "Session_Time", "Time") {
        @Override
        public double getComparedValue(final String input) {
            final SessionTimeResource resource = new SessionTimeResource(input);
            final SessionTime sessionTime = new SessionTimeMapper().toDomainModel(resource);
            return sessionTime.totalSeconds();
        }
    },

    SESSION_DATE(FilterableField.SESSION_DATE, "SessionDate", "Session_Date", "Date") {
        @Override
        public double getComparedValue(final String input) {
            final SessionDateResource resource = new SessionDateResource(input);
            final SessionDate sessionDate = new SessionDateMapper().toDomainModel(resource);
            LocalDateTime l = LocalDateTime.of(sessionDate.year().value(), sessionDate.month().value(), sessionDate.day().value(), 0, 0);
            ZonedDateTime zdt = ZonedDateTime.of(l, ZoneId.systemDefault());
            return zdt.toInstant().toEpochMilli();
        }
    },

    SESSION_TYPE(FilterableField.SESSION_TYPE, "Type", "SessionType", "Session_Type") {
        @Override
        public double getComparedValue(String input) {
            for(final SessionType sessionType : SessionType.values()) {
                if(sessionType.name().equalsIgnoreCase(input)) {
                    return sessionType.ordinal();
                }
            }
            throw new ComparedValueNotParsable("Value must be one of [" + validSessionTypes() + "]");
        }

        private String validSessionTypes() {
            final StringBuilder validSessionTypes = new StringBuilder();
            Arrays.stream(SessionType.values()).forEach(type -> validSessionTypes.append(type.name()));
            return validSessionTypes.toString();
        }

    };

    private final FilterableField filterableField;
    private final List<String> acceptedFieldNames;

    FilterableFieldAdapter(FilterableField filterableField, String... acceptedFieldNames) {
        this.filterableField = filterableField;
        this.acceptedFieldNames = Arrays.asList(acceptedFieldNames);
    }

    public abstract double getComparedValue(String input);

    public FilterableField getFilterableField() {
        return filterableField;
    }

    public static FilterableFieldAdapter getAdapter(final String fieldName) {
        for(FilterableFieldAdapter adapter : FilterableFieldAdapter.values()) {
            for(String acceptedFieldName : adapter.acceptedFieldNames) {
                if(fieldName.equalsIgnoreCase(acceptedFieldName)) {
                    return adapter;
                }
            }
        }
        throw new IllegalArgumentException();
    }

}
