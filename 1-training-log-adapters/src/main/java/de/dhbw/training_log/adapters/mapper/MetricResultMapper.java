package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.adapters.resource.MetricResultResource;
import de.dhbw.training_log.de.metric.Metric;

public class MetricResultMapper implements SessionResourceMapper<MetricResultResource, Metric.MetricResult> {

    public MetricResultResource toResource(Metric.MetricResult metricResult) {
        return new MetricResultResource(metricResult.name(), metricResult.result(), metricResult.resultClass());
    }

    @Override
    public Metric.MetricResult toDomainModel(MetricResultResource resource) {
        return new Metric.MetricResult(resource.getMetricName(), resource.getResult());
    }

}
