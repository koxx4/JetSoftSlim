package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.model.*;

import java.util.List;
import java.util.Optional;

public interface FlightRepository {

    void saveFlight(Reservation reservation);
    void deleteFlight(Long reservationId);
    List<Reservation> getAllFlights();
}
