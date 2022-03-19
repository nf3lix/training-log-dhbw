package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import dhbw.training_log.de.time.Minutes;
import dhbw.training_log.de.time.Seconds;
import dhbw.training_log.de.time.SessionTime;

public class SessionTimeMapper implements SessionResourceMapper<SessionTimeResource, SessionTime> {

    @Override
    public SessionTimeResource toResource(SessionTime sessionTime) {
        return new SessionTimeResource(sessionTime.minutes() + ":" + sessionTime.seconds());
    }

    @Override
    public SessionTime toDomainModel(SessionTimeResource resource) {
        return new SessionTime(new Minutes(resource.minutes()), new Seconds(resource.seconds()));
    }

}
