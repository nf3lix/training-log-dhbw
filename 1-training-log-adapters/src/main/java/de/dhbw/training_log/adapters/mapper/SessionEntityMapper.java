package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.SessionResource;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.description.Description;
import de.dhbw.training_log.de.session.training_session_id.SessionId;

public class SessionEntityMapper implements SessionResourceMapper<SessionResource, Session> {

    private final DistanceMapper distanceMapper = new DistanceMapper();
    private final SessionTimeMapper sessionTimeMapper = new SessionTimeMapper();
    private final SessionDateMapper sessionDateMapper = new SessionDateMapper();

    @Override
    public SessionResource toResource(Object domainModelObject) {
        final Session session = (Session) domainModelObject;
        return new SessionResource(
                session.id().uuid(),
                sessionDateMapper.toResource(session.date()),
                distanceMapper.toResource(session.distance()),
                sessionTimeMapper.toResource(session.time()),
                session.description().stringValue(),
                session.type()
        );
    }

    @Override
    public Session toDomainModel(SessionResource resource) {
        return new Session(
                new SessionId(resource.id()),
                sessionDateMapper.toDomainModel(resource.sessionDate()),
                distanceMapper.toDomainModel(resource.distance()),
                sessionTimeMapper.toDomainModel(resource.sessionTime()),
                new Description(resource.description()),
                resource.type()
        );
    }

}
