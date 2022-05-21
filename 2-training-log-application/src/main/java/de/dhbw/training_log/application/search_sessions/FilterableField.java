package de.dhbw.training_log.application.search_sessions;

import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.DistanceUnit;

import java.time.*;
import java.util.function.Function;

public enum FilterableField {

    DISTANCE {
        @Override
        Function<? super Session, Double> mapper() {
            return session -> session.distance().getIn(DistanceUnit.METERS);
        }
    },

    SESSION_TIME {
        @Override
        Function<? super Session, Double> mapper() {
            return session -> (double) session.time().totalSeconds();
        }
    },

    SESSION_DATE {
        @Override
        Function<? super Session, Double> mapper() {
            return (Function<Session, Double>) session -> {
                LocalDateTime l = LocalDateTime.of(session.date().year().value(), session.date().month().value(), session.date().day().value(), 0, 0);
                ZonedDateTime zdt = ZonedDateTime.of(l, ZoneId.systemDefault());
                return (double) zdt.toInstant().toEpochMilli();
            };
        }
    },

    SESSION_TYPE {
        @Override
        Function<? super Session, Double> mapper() {
            return (Function<Session, Double>) session -> (double) session.type().ordinal();
        }
    };

    abstract Function<? super Session, Double> mapper();

}
