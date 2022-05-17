package de.dhbw.training_log.adapters.resource;

public class SessionTimeResource {

    private final int minutes;
    private final int seconds;

    public SessionTimeResource(final String input) {
        if(!input.matches("[0-9]*:[0-9]{1,2}")) {
            throw new IllegalArgumentException("Session Time must be in the format mm:ss");
        }
        final String[] split = input.split(":");
        final int minutes = Integer.parseInt(split[0]);
        final int seconds = Integer.parseInt(split[1]);
        if(seconds >= 60) {
            throw  new NumberFormatException("Seconds must be less than 60");
        }
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int minutes() {
        return this.minutes;
    }

    public int seconds() {
        return this.seconds;
    }

    @Override
    public String toString() {
        String displayedSeconds;
        if(seconds > 9) {
            displayedSeconds = String.valueOf(seconds);
        } else {
            displayedSeconds = "0" + seconds;
        }
        return minutes + ":" + displayedSeconds;
    }
}
