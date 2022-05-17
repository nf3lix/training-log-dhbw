package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.SessionDateResource;
import de.dhbw.training_log.de.session.session_date.SessionDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static de.dhbw.training_log.de.session.session_date.SessionDate.*;

public class SessionDateMapper implements SessionResourceMapper<SessionDateResource, SessionDate> {

    @Override
    public SessionDateResource toResource(Object domainModelObject) {
        final SessionDate sessionDate = (SessionDate) domainModelObject;
        final LocalDate localDate = LocalDate.of(
                sessionDate.year().value(),
                sessionDate.month().value(),
                sessionDate.day().value());
        final String formattedDate = localDate.format(DateTimeFormatter.ofPattern(SessionDateResource.DATE_FORMAT));
        return new SessionDateResource(formattedDate);
    }

    @Override
    public SessionDate toDomainModel(SessionDateResource resource) {
        final int year = resource.year();
        final int month = resource.month();
        final int day = resource.day();
        return new SessionDate(new Year(year), new Month(month), new DayOfMonth(day));
    }

}
