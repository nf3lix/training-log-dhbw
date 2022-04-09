package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.adapters.mapper.SessionResourceMapper;

public class MetricResultResource {

    private final String metricName;
    private final Object result;
    private final Class<?> resultClass;

    public MetricResultResource(final String metricName, final Object result, final Class<?> resultClass) {
        this.metricName = metricName;
        this.resultClass = resultClass;
        this.result = result;
    }

    public String getMetricName() {
        return metricName;
    }

    public Object getResult() {
        return result;
    }

    @Override
    public String toString() {
        String output = result.toString();
        final SessionResourceMapper<?, ?> mapper = SessionResourceMapper.getMapper(resultClass);
        if(mapper != null) {
            output = mapper.toResource(resultClass.cast(result)).toString();
        }
        return this.metricName + " - " + output;
    }
}
