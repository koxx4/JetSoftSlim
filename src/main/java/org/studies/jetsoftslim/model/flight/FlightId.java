package org.studies.jetsoftslim.model.flight;

import java.util.Objects;

public class FlightId {

    private final Long value;

    private FlightId(Long value) {

        this.value = value;
    }

    public static FlightId of(Long value) {

        return new FlightId(value);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightId flightId = (FlightId) o;
        return Objects.equals(value, flightId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
