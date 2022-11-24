package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.model.flight.Flight;
import org.studies.jetsoftslim.model.flight.FlightId;

public interface FlightRepository {

    void saveFlight(Flight flight);

    void deleteFlightById(FlightId flightId);
}
