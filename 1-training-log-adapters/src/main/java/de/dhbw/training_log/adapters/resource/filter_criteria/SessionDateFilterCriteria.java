package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.adapters.resource.SessionDateResource;

public class SessionDateFilterCriteria extends FilterCriteriaResource<SessionDateResource> {

    public SessionDateFilterCriteria(String input) {
        super(input);
    }

    @Override
    SessionDateResource parseStringValue(String input) {
        return new SessionDateResource(input);
    }
}
