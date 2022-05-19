package de.dhbw.training_log.adapters.usecase.filter_sessions;

import de.dhbw.training_log.adapters.mapper.DistanceMapper;
import de.dhbw.training_log.adapters.mapper.SessionDateMapper;
import de.dhbw.training_log.adapters.mapper.SessionTimeMapper;
import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.adapters.resource.SessionDateResource;
import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import de.dhbw.training_log.application.filter.FilterableSessionField;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.SessionTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class FilterableFields {

    private final Map<String, FilterableSessionField> fields = new HashMap<>();

    public FilterableFields() {

        fields.put("Distance", new FilterableSessionField() {
            @Override
            public double numericalValueFromString(String input) {
                final DistanceResource resource = new DistanceResource(input);
                final Distance distance = new DistanceMapper().toDomainModel(resource);
                return distance.getIn(DistanceUnit.METERS);
            }

            @Override
            public double numericalValueFromSession(Session session) {
                return session.distance().getIn(DistanceUnit.METERS);
            }
        });

        fields.put("SessionTime", new FilterableSessionField() {
            @Override
            public double numericalValueFromString(String input) {
                final SessionTimeResource resource = new SessionTimeResource(input);
                final SessionTime sessionTime = new SessionTimeMapper().toDomainModel(resource);
                return sessionTime.totalSeconds();
            }

            @Override
            public double numericalValueFromSession(Session session) {
                return session.time().totalSeconds();
            }
        });

        fields.put("SessionDate", new FilterableSessionField() {
            @Override
            public double numericalValueFromString(String input) {
                final SessionDateResource resource = new SessionDateResource(input);
                final SessionDate sessionDate = new SessionDateMapper().toDomainModel(resource);
                return (double) Instant.from(LocalDate.of(sessionDate.year().value(), sessionDate.month().value(), sessionDate.day().value())).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            }

            @Override
            public double numericalValueFromSession(Session session) {
                return (double) Instant.from(LocalDate.of(session.date().year().value(), session.date().month().value(), session.date().day().value())).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            }
        });

    }



}
