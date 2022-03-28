package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.metric.AggregateFunction.AVG;
import de.dhbw.training_log.de.metric.AggregateFunction.COUNT;
import de.dhbw.training_log.de.metric.AggregateFunction.MAX;
import de.dhbw.training_log.de.metric.AggregateFunction.MIN;
import de.dhbw.training_log.de.round.Round;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;

import java.util.List;
import java.util.stream.Collectors;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;

public final class StandardMetrics {

    public static final class TotalSessionsMetric extends Metric<Session, Integer> {
        public TotalSessionsMetric() {
            super(new COUNT<>());
        }
    }

    public static final class MaxDistanceMetric extends Metric<Distance, Distance> {
        public MaxDistanceMetric() {
            super(new MAX<>());
        }
    }

    public static final class MinDistanceMetric extends Metric<Distance, Distance> {
        public MinDistanceMetric() {
            super(new MIN<>());
        }
    }

    public static final class AvgDistanceMetric extends Metric<Distance, Distance> {
        public AvgDistanceMetric() {
            super(new AVG<>());
        }
    }

    public static final class AvgTimePerKilometer extends Metric<Session, SessionTime> {
        public AvgTimePerKilometer() {
            super(new Pace());
        }

        private static final class Pace extends AggregateFunction<Session, SessionTime> {
            @Override
            public SessionTime compute(List<Session> list) {
                final Distance totalDistance = totalDistance(list);
                final SessionTime totalTime = totalTime(list);
                final Integer seconds = totalTime.seconds() + totalTime.minutes() * 60;
                return new SessionTime(new Minutes(0), new Seconds(Round.roundToInt(seconds / totalDistance.getIn(KILOMETERS))));
            }

            private Distance totalDistance(final List<Session> sessions) {
                final List<Distance> distances = sessions.stream().map(Session::distance).collect(Collectors.toList());
                return new SUM<Distance>().compute(distances);
            }

            private SessionTime totalTime(final List<Session> sessions) {
                final List<SessionTime> sessionTimes = sessions.stream().map(Session::time).collect(Collectors.toList());
                return new SUM<SessionTime>().compute(sessionTimes);
            }

        }

    }

}
