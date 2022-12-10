package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.FlightRepository;
import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.Pilot;
import org.studies.jetsoftslim.model.Route;
import org.studies.jetsoftslim.model.Vehicle;

import java.util.List;

public class InMemoryFlightRepository implements FlightRepository {

    private List<Flight> flightList;
    private List<Pilot> pilotList;
    private List<Vehicle> vehicleList;
    private List<Route> routeList;
    private EntityIdGenerator idGenerator;

    public InMemoryFlightRepository(EntityIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void saveFlight(Flight flight) {

    }

    @Override
    public void deleteFlightById(Long flightId) {

    }

    @Override
    public List<Flight> getAllFlights() {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return null;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {

    }

    @Override
    public List<Pilot> getAllPilots() {
        return null;
    }

    @Override
    public void savePilot(Pilot pilot) {

    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }

    @Override
    public void saveRoute(Route route) {

    }

    @Override
    public Flight getFlightById(Long flightId) {
        return null;
    }
}
