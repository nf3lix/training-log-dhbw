package de.dhbw.training_log.application.filter;

import de.dhbw.training_log.de.session.Session;

public abstract class FilterableSessionField {
    
    public abstract double numericalValueFromString(final String input);
    public abstract double numericalValueFromSession(final Session session);

}
