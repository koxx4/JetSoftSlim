package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.FlightQueries;
import org.studies.jetsoftslim.model.FlightFilterForm;
import org.studies.jetsoftslim.model.flight.Flight;

import java.util.List;

public class InMemoryFlightQueries implements FlightQueries {

    @Override
    public List<Flight> listFlightsByFilterForm(FlightFilterForm filterForm) {
        return null;
    }
}
