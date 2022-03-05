package de.dhbw.training_log.adapters;

import de.dhbw.training_log.adapters.training_session_ressource.SessionTimeResource;

import java.util.function.Function;

public class TrainingSessionResourceMapper {

    public static class SessionTimeMapper implements Function<String, SessionTimeResource> {
        @Override
        public SessionTimeResource apply(String s) {
            return new SessionTimeResource(s);
        }
    }

}
