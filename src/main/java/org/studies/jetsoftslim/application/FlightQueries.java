package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.model.FlightFilterForm;
import org.studies.jetsoftslim.model.flight.Flight;

import java.util.List;

public interface FlightQueries {

    List<Flight> listFlightsByFilterForm(FlightFilterForm filterForm);
}
