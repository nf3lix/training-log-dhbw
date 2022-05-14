package de.dhbw.training_log.adapters.resource.filter_criteria;

import de.dhbw.training_log.adapters.resource.SessionTimeResource;

public class SessionTimeFilterCriteria extends FilterCriteriaResource<SessionTimeResource> {

    public SessionTimeFilterCriteria(final String input) {
        super(input);
    }

    @Override
    SessionTimeResource parseStringValue(final String input) {
        return new SessionTimeResource(input);
    }

}
