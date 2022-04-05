package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.session.Session;

import java.util.List;

public abstract class Metric {

    public abstract MetricResult compute(final List<Session> list);

    public interface MetricResult {
        String name();
        Object result();
    }

}
