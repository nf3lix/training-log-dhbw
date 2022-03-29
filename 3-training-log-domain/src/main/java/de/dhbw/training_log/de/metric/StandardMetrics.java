package de.dhbw.training_log.de.metric;

import de.dhbw.training_log.de.metric.AggregateFunction.AVG;
import de.dhbw.training_log.de.metric.AggregateFunction.MAX;
import de.dhbw.training_log.de.metric.AggregateFunction.MIN;
import de.dhbw.training_log.de.round.Round;
import de.dhbw.training_log.de.session.Session;
import de.dhbw.training_log.de.session.distance.Distance;
import de.dhbw.training_log.de.session.time.Minutes;
import de.dhbw.training_log.de.session.time.Seconds;
import de.dhbw.training_log.de.session.time.SessionTime;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static de.dhbw.training_log.de.session.distance.DistanceUnit.KILOMETERS;

public final class StandardMetrics {

    public static final class TotalSessionsMetric extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            return new MetricResult(list.size());
        }
    }

    public static final class MaxDistanceMetric extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            return computeMaximumFor(list, Session::distance);
        }
    }

    public static final class MinDistanceMetric extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            return computeMinimumFor(list, Session::distance);
        }
    }

    public static final class AvgDistanceMetric extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            final List<Distance> distances = list.stream().map(Session::distance).collect(Collectors.toList());
            final Distance avgDistance = new AVG<Distance>().compute(distances);
            return new MetricResult(avgDistance);
        }
    }

    public static final class MaxSessionTimeMetric extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            return computeMaximumFor(list, Session::time);
        }
    }

    public static final class MinSessionTimeMetric extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            return computeMinimumFor(list, Session::time);
        }
    }

    public static final class AvgSessionTimeMetric extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            final List<SessionTime> sessionTimes = list.stream().map(Session::time).collect(Collectors.toList());
            final SessionTime avgSessionTime = new AVG<SessionTime>().compute(sessionTimes);
            return new MetricResult(avgSessionTime);
        }
    }

    public static final class AvgTimePerKilometer extends Metric {
        @Override
        public MetricResult compute(List<Session> list) {
            return new MetricResult(timePerKilometer(list));
        }

        private SessionTime timePerKilometer(final List<Session> sessionList) {
            final Distance totalDistance = totalDistance(sessionList);
            final SessionTime totalTime = totalTime(sessionList);
            final Integer seconds = totalTime.seconds() + totalTime.minutes() * 60;
            return new SessionTime(new Minutes(0), new Seconds(Round.roundToInt(seconds / totalDistance.getIn(KILOMETERS))));
        }

        private Distance totalDistance(final List<Session> sessions) {
            final List<Distance> distances = sessions.stream().map(Session::distance).collect(Collectors.toList());
            return new AggregateFunction.SUM<Distance>().compute(distances);
        }

        private SessionTime totalTime(final List<Session> sessions) {
            final List<SessionTime> sessionTimes = sessions.stream().map(Session::time).collect(Collectors.toList());
            return new AggregateFunction.SUM<SessionTime>().compute(sessionTimes);
        }

    }

    private static <T extends Comparable<T>> Metric.MetricResult computeMaximumFor(final List<Session> sessionList, final Function<? super Session, ? extends T> mapper) {
        return computeAggregateFor(sessionList, mapper, new MAX<>());
    }

    private static <T extends Comparable<T>> Metric.MetricResult computeMinimumFor(final List<Session> sessionList, final Function<? super Session, ? extends T> mapper) {
        return computeAggregateFor(sessionList, mapper, new MIN<>());
    }

    private static <T extends Comparable<T>> Metric.MetricResult computeAggregateFor(final List<Session> sessionList, final Function<? super Session, ? extends T> mapper, final AggregateFunction<T, T> aggregateFunction) {
        final List<T> itemList = sessionList.stream().map(mapper).collect(Collectors.toList());
        final Map<T, Session> sessions = sessionList.stream().collect(Collectors.toMap(mapper, Function.identity()));
        final T selectedItem = aggregateFunction.compute(itemList);
        return new Metric.MetricResult(sessions.get(selectedItem));
    }

}
