package de.dhbw.training_log.adapters.training_session_ressource;

public class InvalidDistanceInput extends IllegalStateException {

    public InvalidDistanceInput() {
        super("Entered distance has invalid format. Needs to be " + DistanceResource.DISPLAYED_FORMAT);
    }

}
