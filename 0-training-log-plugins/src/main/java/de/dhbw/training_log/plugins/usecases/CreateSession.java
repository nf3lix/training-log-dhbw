package de.dhbw.training_log.plugins.usecases;

import de.dhbw.training_log.adapters.SessionResource;
import de.dhbw.training_log.adapters.SessionResourceMapper;
import de.dhbw.training_log.adapters.training_session_ressource.DistanceResource;
import de.dhbw.training_log.adapters.training_session_ressource.SessionTimeResource;
import de.dhbw.training_log.adapters.training_session_ressource.SessionTypeMapper;
import de.dhbw.training_log.application.crud_training_session.SessionService;
import dhbw.training_log.de.SessionRepository;
import dhbw.training_log.de.training_session_type.SessionType;

import static de.dhbw.training_log.adapters.SessionResourceMapper.DistanceMapper;
import static de.dhbw.training_log.adapters.SessionResourceMapper.SessionTimeMapper;

class CreateSession extends UseCaseInitializer {

    private final SessionResourceMapper resourceMapper = new SessionResourceMapper();

    @Override
    void init(final SessionRepository repository) {
        final DistanceResource distance = askForDistance();
        final SessionTimeResource sessionTime = askForSessionTime();
        final SessionType type = askForSessionType();
        final String description = askForDescription();
        final SessionResource resource = new SessionResource(
                repository.nextId().uuid(),
                distance,
                sessionTime,
                description,
                type
        );
        new SessionService(repository).createTrainingSession(resourceMapper.getEntity(resource));
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

    private SessionType askForSessionType() {
        System.out.print("Enter type: ");
        System.out.println(sessionTypeOptions());
        return SessionTypeMapper.mapToType(CommandLine.readLine());
    }

    private String askForDescription() {
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

}
