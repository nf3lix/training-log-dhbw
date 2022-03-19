package de.dhbw.training_log.plugins.usecases.create_session;

import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.adapters.resource.SessionTimeResource;
import de.dhbw.training_log.adapters.mapper.DistanceMapper;
import de.dhbw.training_log.adapters.mapper.SessionTimeMapper;
import de.dhbw.training_log.adapters.mapper.SessionTypeMapper;
import de.dhbw.training_log.application.crud_training_session.CreateSessionService;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.de.SessionRepository;
import de.dhbw.training_log.de.description.Description;
import de.dhbw.training_log.de.distance.Distance;
import de.dhbw.training_log.de.time.SessionTime;
import de.dhbw.training_log.de.training_session_type.SessionType;

public class CreateSessionServiceImpl extends CreateSessionService {

    public CreateSessionServiceImpl(final SessionRepository repository) {
        super(repository);
    }

    @Override
    protected Distance askForDistance() {
        System.out.print("Enter distance (format: " + DistanceResource.DISPLAYED_FORMAT + "): ");
        final String input = CommandLine.readLine();
        final DistanceResource distanceResource = new DistanceResource(input);
        return new DistanceMapper().toDomainModel(distanceResource);
    }

    @Override
    protected SessionTime askForSessionTime() {
        System.out.print("Enter time (format: <mm>:<ss>): ");
        final String input = CommandLine.readLine();
        final SessionTimeResource sessionTimeResource = new SessionTimeResource(input);
        return new SessionTimeMapper().toDomainModel(sessionTimeResource);
    }

    @Override
    protected SessionType askForSessionType() {
        System.out.print("Enter type: ");
        System.out.println(sessionTypeOptions());
        return SessionTypeMapper.mapToType(CommandLine.readLine());
    }

    @Override
    protected Description askForDescription() {
        System.out.print("Enter a description: ");
        final String input = CommandLine.readLine();
        return new Description(input);
    }

    private String sessionTypeOptions() {
        final StringBuilder typeOptions = new StringBuilder();
        for(final SessionType type : SessionType.values()) {
            typeOptions
                    .append("\n\t")
                    .append(SessionTypeMapper.mapToAbbreviation(type))
                    .append(") ")
                    .append(type.name());
        }
        return typeOptions.toString();
    }

}
