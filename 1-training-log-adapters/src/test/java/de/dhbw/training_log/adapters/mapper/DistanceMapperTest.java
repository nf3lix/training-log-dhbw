package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.DistanceResource;
import dhbw.training_log.de.distance.Distance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dhbw.training_log.de.distance.DistanceUnit.*;

public class DistanceMapperTest {

    private final DistanceMapper mapper = new DistanceMapper();

    @Test
    public void mapToResource() {
        final Distance distance1 = new Distance(12.0, KILOMETERS);
        final Distance distance2 = new Distance(11.0, METERS);
        final Distance distance3 = new Distance(11.0, MILES);
        final DistanceResource resource1 = mapper.toResource(distance1);
        final DistanceResource resource2 = mapper.toResource(distance2);
        final DistanceResource resource3 = mapper.toResource(distance3);
        Assertions.assertEquals(resource1.distance(), 12000.0);
        Assertions.assertEquals(resource1.unit(), METERS);
        Assertions.assertEquals(resource2.distance(), 11.0);
        Assertions.assertEquals(resource2.unit(), METERS);
        Assertions.assertEquals(resource3.distance(), 17702.784);
        Assertions.assertEquals(resource3.unit(), METERS);
    }

    @Test
    public void mapToDomainModel() {
        final DistanceResource resource1 = new DistanceResource("10 KILOMETERS");
        final DistanceResource resource2 = new DistanceResource("11 MILES");
        final DistanceResource resource3 = new DistanceResource("700 METERS");
        final Distance distance1 = mapper.toDomainModel(resource1);
        final Distance distance2 = mapper.toDomainModel(resource2);
        final Distance distance3 = mapper.toDomainModel(resource3);
        Assertions.assertEquals(distance1.getIn(KILOMETERS), 10);
        Assertions.assertEquals(distance2.getIn(MILES), 11);
        Assertions.assertEquals(distance3.getIn(METERS), 700);
    }

}
