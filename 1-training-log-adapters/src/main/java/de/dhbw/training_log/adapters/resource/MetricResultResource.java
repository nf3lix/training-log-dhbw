package de.dhbw.training_log.adapters.resource;

public class MetricResultResource {

    private final String metricName;
    private final Object result;

    public MetricResultResource(final String metricName, final Object result) {
        this.metricName = metricName;
        this.result = result;
    }

    @Override
    public String toString() {
        return this.metricName + " - " + result.toString();
    }
}
