package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.DistanceResource;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.distance.DistanceUnit;

public class DistanceMapper implements SessionResourceMapper<DistanceResource, Distance> {

    private static final DistanceUnit RESOURCE_UNIT = DistanceUnit.METERS;

    @Override
    public DistanceResource toResource(Distance distance) {
        return new DistanceResource(distance.getIn(RESOURCE_UNIT) + " " + RESOURCE_UNIT.name());
    }

    @Override
    public Distance toDomainModel(DistanceResource resource) {
        return new Distance(resource.distance(), resource.unit());
    }

}
