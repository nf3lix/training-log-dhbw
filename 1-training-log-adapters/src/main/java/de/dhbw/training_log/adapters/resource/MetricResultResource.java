package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.adapters.mapper.DistanceMapper;
import de.dhbw.training_log.adapters.mapper.SessionEntityMapper;
import de.dhbw.training_log.adapters.mapper.SessionTimeMapper;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.time.SessionTime;

public class MetricResultResource {

    private final String metricName;
    private final Object result;

    public MetricResultResource(final String metricName, final Object result) {
        this.metricName = metricName;
        this.result = result;
    }

    @Override
    public String toString() {
        String output = result.toString();
        if(result instanceof Session) {
            output = new SessionEntityMapper().toResource((Session) result).toString();
        }
        if(result instanceof SessionTime) {
            output = new SessionTimeMapper().toResource((SessionTime) result).toString();
        }
        if(result instanceof Distance) {
            output = new DistanceMapper().toResource((Distance) result).toString();
        }
        return this.metricName + " - " + output;
    }
}
