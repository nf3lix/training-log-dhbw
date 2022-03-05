package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.adapters.training_session_ressource.TrainingSessionTypeMapper;
import de.dhbw.training_log.adapters.training_session_ressource.DistanceResource;
import de.dhbw.training_log.adapters.training_session_ressource.SessionTimeResource;
import dhbw.training_log.de.training_session_type.TrainingSessionType;

import static de.dhbw.training_log.adapters.TrainingSessionResourceMapper.DistanceMapper;
import static de.dhbw.training_log.adapters.TrainingSessionResourceMapper.SessionTimeMapper;

class CreateTrainingSession extends UseCaseInitializer {

    @Override
    void init() {
        final DistanceResource distance = askForDistance();
        final SessionTimeResource sessionTime = askForSessionTime();
        TrainingSessionType type = askForSessionType();
        String description = askForDescription();
    }

    private DistanceResource askForDistance() {
        System.out.print("Enter distance (format: " + DistanceResource.DISPLAYED_FORMAT + "): ");
        final String input = CommandLine.readLine();
        return new DistanceMapper().apply(input);
    }

    private SessionTimeResource askForSessionTime() {
        System.out.print("Enter time (format: <mm>:<ss>): ");
        final String input = CommandLine.readLine();
        return new SessionTimeMapper().apply(input);
    }

    private TrainingSessionType askForSessionType() {
        System.out.print("Enter type: ");
        System.out.println(sessionTypeOptions());
        return TrainingSessionTypeMapper.mapToType(CommandLine.readLine());
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
                    .append(TrainingSessionTypeMapper.mapToAbbreviation(type))
                    .append(") ")
                    .append(type.name());
        }
        return typeOptions.toString();
    }

}
