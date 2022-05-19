package de.dhbw.training_log.de.session.session_date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

public final class SessionDate implements Comparable<SessionDate> {

    private final LocalDate localDate;

    public SessionDate(final Year year, final Month month, final DayOfMonth day) {
        this.localDate = LocalDate.of(year.value(), month.value(), day.value());

    }

    public Year year() {
        return new Year(localDate.getYear());
    }

    public Month month() {
        return new Month(localDate.getMonthValue());
    }

    public DayOfMonth day() {
        return new DayOfMonth(localDate.getDayOfMonth());
    }

    @Override
    public int compareTo(SessionDate sessionDate) {
        return localDate.compareTo(sessionDate.localDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionDate that = (SessionDate) o;
        return Objects.equals(localDate, that.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate);
    }

    public static final class Year {
        private final int year;
        public Year(final int year) {
            this.year = year;
        }

        public int value() {
            return year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Year year1 = (Year) o;
            return year == year1.year;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year);
        }

    }

    public static final class Month {
        private final int month;
        public Month(final int month) {
            if(month < 1 || month > 12) {
                throw new IllegalArgumentException();
            }
            this.month = month;
        }

        public int value() {
            return month;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Month month1 = (Month) o;
            return month == month1.month;
        }

        @Override
        public int hashCode() {
            return Objects.hash(month);
        }
    }

    public static final class DayOfMonth {
        private final int day;
        public DayOfMonth(final int day) {
            if(day < 1 || day > 31) {
                throw new IllegalArgumentException();
            }
            this.day = day;
        }

        public int value() {
            return day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DayOfMonth that = (DayOfMonth) o;
            return day == that.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(day);
        }
    }

}
