package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.adapters.TrainingSessionTypeAdapter;
import dhbw.training_log.de.training_session_type.TrainingSessionType;

class CreateTrainingSession extends UseCaseInitializer {

    @Override
    void init() {
        String distance = askForDistance();
        String sessionTime = askForSessionTime();
        String sessionType = askForSessionType();
        String description = askForDescription();
    }

    private String askForDistance() {
        System.out.print("Enter distance (format: <distance><unit>): ");
        return CommandLine.readLine();
    }

    private String askForSessionTime() {
        System.out.print("Enter time (format: <mm>:<ss>): ");
        return CommandLine.readLine();
    }

    private String askForSessionType() {
        System.out.print("Enter type: ");
        System.out.println(sessionTypeOptions());
        return CommandLine.readLine();
    }

    private String askForDescription() {
        System.out.print("Enter a description: ");
        return CommandLine.readLine();
    }

    private String sessionTypeOptions() {
        final StringBuilder typeOptions = new StringBuilder();
        for(final TrainingSessionType type : TrainingSessionType.values()) {
            typeOptions
                    .append("\n\t")
                    .append(TrainingSessionTypeAdapter.mapToAbbreviation(type))
                    .append(") ")
                    .append(type.name());
        }
        return typeOptions.toString();
    }

}
