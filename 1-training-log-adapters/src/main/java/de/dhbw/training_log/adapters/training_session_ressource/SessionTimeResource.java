package de.dhbw.training_log.adapters.training_session_ressource;

public class SessionTimeResource {

    private final Integer minutes;
    private final Integer seconds;

    public SessionTimeResource(final String input) {
        final String[] split = input.split(":");
        if(findOccurrencesIn(input, ':') != 1 || split.length != 2) {
            throw new IllegalArgumentException("Session Time must be in the format mm:ss");
        }
        final int minutes = Integer.parseInt(split[0]);
        final int seconds = Integer.parseInt(split[1]);
        if(seconds >= 60) {
            throw  new NumberFormatException("Seconds must be less than 60");
        }
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Integer minutes() {
        return this.minutes;
    }

    public Integer seconds() {
        return this.seconds;
    }

    private Integer findOccurrencesIn(final String input, final Character c) {
        Integer count = 0;
        for(int index = 0; index < input.length(); index++) {
            if(input.charAt(index) == c) {
                count++;
            }
        }
        return count;
    }

}
