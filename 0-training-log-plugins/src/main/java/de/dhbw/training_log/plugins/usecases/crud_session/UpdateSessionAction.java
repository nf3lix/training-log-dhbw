package de.dhbw.training_log.plugins.usecases.crud_session;

import de.dhbw.training_log.adapters.mapper.SessionTypeMapper;
import de.dhbw.training_log.adapters.resource.*;
import de.dhbw.training_log.adapters.usecase.crud_session.CreateSessionUseCase;
import de.dhbw.training_log.de.session.SessionRepository;
import de.dhbw.training_log.de.session.training_session_type.SessionType;
import de.dhbw.training_log.plugins.CommandLine;
import de.dhbw.training_log.plugins.action.UserAction;

import java.util.UUID;

public class UpdateSessionAction implements UserAction {

    private final CreateSessionUseCase service;

    public UpdateSessionAction(final SessionRepository repository) {
        this.service = new CreateSessionUseCase(repository);
    }

    @Override
    public void initialize() {
        final UUID id = getId();
        final SessionDateResource sessionDate = getDate();
        final DistanceResource distance = getDistance();
        final SessionTimeResource sessionTime = getSessionTime();
        final SessionType sessionType = getSessionType();
        final String description = getSessionDescription();
        final SessionResource resource = new SessionResource(id, sessionDate, distance,
                sessionTime, description, sessionType);
        service.run(resource);
    }

    private UUID getId() {
        System.out.println("Enter id: ");
        final String input = CommandLine.readLine();
        return UUID.fromString(input);
    }

    private DistanceResource getDistance() {
        System.out.print("Enter distance (format: <distance> <METERS|KILOMETERS|MILES>): ");
        final String input = CommandLine.readLine();
        return new DistanceResource(input);
    }

    private SessionDateResource getDate() {
        SessionDateResource sessionDateResource = null;
        while (sessionDateResource == null) {
            System.out.print("Enter the date of session (format: " + SessionDateResource.DATE_FORMAT + "): ");
            final String input = CommandLine.readLine();
            try {
                sessionDateResource = new SessionDateResource(input);
            } catch (InvalidDateFormat e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionDateResource;
    }

    private SessionTimeResource getSessionTime() {
        System.out.print("Enter time (format: <mm>:<ss>): ");
        final String input = CommandLine.readLine();
        return new SessionTimeResource(input);
    }

    private SessionType getSessionType() {
        System.out.print("Enter type: ");
        System.out.println(sessionTypeOptions());
        return SessionTypeMapper.mapToType(CommandLine.readLine());
    }

    private String getSessionDescription() {
        System.out.print("Enter a description: ");
        return CommandLine.readLine();
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

    @Override
    public String getDescription() {
        return "Edit training session";
    }

}
