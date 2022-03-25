package de.dhbw.training_log.de.description;

import java.util.Objects;

public final class Description {

    private final String value;

    public Description(final String value) {
        this.value = value;
    }

    public String stringValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
