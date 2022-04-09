package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.MetricResultResource;
import de.dhbw.training_log.de.metric.Metric;

public class MetricResultMapper implements SessionResourceMapper<MetricResultResource, Metric.MetricResult> {

    public MetricResultResource toResource(Object domainModelObject) {
        final Metric.MetricResult metricResult = (Metric.MetricResult) domainModelObject;
        return new MetricResultResource(metricResult.name(), metricResult.result(), metricResult.resultClass());
    }

    @Override
    public Metric.MetricResult toDomainModel(MetricResultResource resource) {
        return null; // TODO
    }

}
