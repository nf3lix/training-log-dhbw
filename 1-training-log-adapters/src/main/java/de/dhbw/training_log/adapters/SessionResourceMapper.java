package de.dhbw.training_log.adapters;

import de.dhbw.training_log.adapters.training_session_ressource.DistanceResource;
import de.dhbw.training_log.adapters.training_session_ressource.SessionTimeResource;
import dhbw.training_log.de.Session;
import dhbw.training_log.de.description.Description;
import dhbw.training_log.de.distance.Distance;
import dhbw.training_log.de.distance.DistanceUnit;
import dhbw.training_log.de.time.Minutes;
import dhbw.training_log.de.time.Seconds;
import dhbw.training_log.de.time.SessionTime;
import dhbw.training_log.de.training_session_id.SessionId;

import java.util.function.Function;

public class SessionResourceMapper {

    public Session getEntity(final SessionResource resource) {
        return new Session(
                new SessionId(resource.id()),
                new Distance(resource.distance().distance(), resource.distance().unit()),
                new SessionTime(new Minutes(resource.sessionTime().minutes()), new Seconds(resource.sessionTime().seconds())),
                new Description(resource.description()),
                resource.type()
        );
    }

    public SessionResource getResource(final Session trainingSession) {
        return new SessionResource(
                trainingSession.id().uuid(),
                new DistanceResource(trainingSession.distance().getIn(DistanceUnit.METERS) + " METERS"),
                new SessionTimeResource(trainingSession.time().minutes() + ":" + trainingSession.time().seconds()),
                trainingSession.description().stringValue(),
                trainingSession.type()
        );
    }

    public static class SessionTimeMapper implements Function<String, SessionTimeResource> {
        @Override
        public SessionTimeResource apply(String s) {
            return new SessionTimeResource(s);
        }
    }

    public static class DistanceMapper implements Function<String, DistanceResource> {
        @Override
        public DistanceResource apply(String s) {
            return new DistanceResource(s);
        }
    }

}
