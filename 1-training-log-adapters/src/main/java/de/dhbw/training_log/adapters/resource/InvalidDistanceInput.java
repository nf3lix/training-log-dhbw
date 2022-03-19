package de.dhbw.training_log.adapters.resource;

public class InvalidDistanceInput extends IllegalStateException {

    public InvalidDistanceInput() {
        super("Entered distance has invalid format. Needs to be " + DistanceResource.DISPLAYED_FORMAT);
    }

}
