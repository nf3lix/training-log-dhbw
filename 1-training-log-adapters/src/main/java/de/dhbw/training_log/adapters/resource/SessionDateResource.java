package de.dhbw.training_log.adapters.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class SessionDateResource {

    public final static String DATE_FORMAT = "dd.MM.yyyy";

    private final LocalDate localDate;

    public SessionDateResource(final String date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        localDate = LocalDate.parse(date, formatter);
    }

    public Integer year() {
        return localDate.getYear();
    }

    public Integer month() {
        return localDate.getMonthValue();
    }

    public Integer day() {
        return localDate.getDayOfMonth();
    }

    @Override
    public String toString() {
        return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}