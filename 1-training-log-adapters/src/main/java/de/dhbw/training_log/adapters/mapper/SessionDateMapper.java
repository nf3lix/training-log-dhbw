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
        final Integer year = resource.year();
        final Integer month = resource.month();
        final Integer day = resource.day();
        return new SessionDate(new Year(year), new Month(month), new DayOfMonth(day));
    }

}
