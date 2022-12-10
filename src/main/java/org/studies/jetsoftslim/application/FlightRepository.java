package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.Pilot;
import org.studies.jetsoftslim.model.Route;
import org.studies.jetsoftslim.model.Vehicle;

import java.util.List;

public interface FlightRepository {

    void saveFlight(Flight flight);
    void deleteFlightById(Long flightId);
    List<Flight> getAllFlights();
    List<Vehicle> getAllVehicles();
    void saveVehicle(Vehicle vehicle);
    List<Pilot> getAllPilots();
    void savePilot(Pilot pilot);
    List<Route> getAllRoutes();
    void saveRoute(Route route);
    Flight getFlightById(Long flightId);
}
