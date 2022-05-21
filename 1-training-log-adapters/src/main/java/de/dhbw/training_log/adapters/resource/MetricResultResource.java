package de.dhbw.training_log.adapters.resource;

import de.dhbw.training_log.adapters.mapper.*;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.session_date.SessionDate;
import de.dhbw.training_log.de.session.time.SessionTime;

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
        final String valueString = ObjectStringMapper.convertToString(this.result, this.resultClass);
        return this.metricName + " - " + valueString;
    }

    private enum ObjectStringMapper {

        SESSION(Session.class) {
            @Override
            String convertValueToString(final Object value) {
                return new SessionEntityMapper().toResource(value).toString();
            }
        },

        DISTANCE(Distance.class) {
            @Override
            String convertValueToString(Object value) {
                return new DistanceMapper().toResource(value).toString();
            }
        },

        SESSION_DATE(SessionDate.class) {
            @Override
            String convertValueToString(Object value) {
                return new SessionDateMapper().toResource(value).toString();
            }
        },

        SESSION_TIME(SessionTime.class) {
            @Override
            String convertValueToString(Object value) {
                return new SessionTimeMapper().toResource(value).toString();
            }
        };

        private final Class<?> valueClass;

        ObjectStringMapper(final Class<?> valueClass) {
            this.valueClass = valueClass;
        }

        abstract String convertValueToString(Object value);

        private static String convertToString(final Object value, final Class<?> valueClass) {
            for(final ObjectStringMapper mapper : ObjectStringMapper.values()) {
                if(valueClass == mapper.valueClass) {
                    return mapper.convertValueToString(value);
                }
            }
            return value.toString();
        }

    }

}
