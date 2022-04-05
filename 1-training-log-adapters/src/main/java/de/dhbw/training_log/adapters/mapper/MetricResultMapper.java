package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.MetricResultResource;
import de.dhbw.training_log.de.metric.Metric;

public class MetricResultMapper {

    public MetricResultResource toResource(Metric.MetricResult domainModelObject) {
        return new MetricResultResource(domainModelObject.name(), domainModelObject.result());
    }

}
