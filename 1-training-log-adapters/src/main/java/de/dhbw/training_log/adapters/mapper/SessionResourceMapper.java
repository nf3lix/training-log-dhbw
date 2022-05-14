package de.dhbw.training_log.adapters.mapper;

import de.dhbw.training_log.de.metric.Metric;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.SessionTime;

import java.util.HashMap;
import java.util.Map;

public interface SessionResourceMapper<T, K> {
    T toResource(final Object domainModelObject);
    K toDomainModel(final T resource);

    static SessionResourceMapper<?, ?> getMapper(Class<?> c) {
        final Map<Class<?>, SessionResourceMapper<?, ?>> mappers = new HashMap<>();
        mappers.put(Session.class, new SessionEntityMapper());
        mappers.put(Distance.class, new DistanceMapper());
        mappers.put(SessionDate.class, new SessionTimeMapper());
        mappers.put(SessionTime.class, new SessionTimeMapper());
        mappers.put(Metric.MetricResult.class, new MetricResultMapper());
        return mappers.get(c);
    }

    /*
    static SessionResourceMapper<?, ?> getValueMapperByClassName(final String className) {
        final Map<String, SessionResourceMapper<?, ?>> mappers = new HashMap<>();
        mappers.put(Distance.class.getName(), new DistanceMapper());
        mappers.put(SessionDate.class.getName(), new SessionTimeMapper());
        mappers.put(SessionTime.class.getName(), new SessionTimeMapper());
        return mappers.get(className);
    }*/

}
