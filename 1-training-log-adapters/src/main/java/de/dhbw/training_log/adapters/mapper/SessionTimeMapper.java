package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;

public class SessionTimeMapper implements SessionResourceMapper<SessionTimeResource, SessionTime> {

    @Override
    public SessionTimeResource toResource(Object domainModelObject) {
        final SessionTime sessionTime = (SessionTime) domainModelObject;
        return new SessionTimeResource(sessionTime.minutes() + ":" + sessionTime.seconds());
    }

    @Override
    public SessionTime toDomainModel(SessionTimeResource resource) {
        return new SessionTime(new Minutes(resource.minutes()), new Seconds(resource.seconds()));
    }

}
