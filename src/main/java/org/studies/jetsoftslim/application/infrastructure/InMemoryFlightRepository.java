package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.FlightRepository;
import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.Pilot;
import org.studies.jetsoftslim.model.Route;
import org.studies.jetsoftslim.model.Vehicle;

import java.util.List;
import java.util.Optional;

public class InMemoryFlightRepository extends InMemoryRepository<Flight> implements FlightRepository {

    private EntityIdGenerator idGenerator;

    public InMemoryFlightRepository(EntityIdGenerator idGenerator) {

        super(idGenerator);

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

        Optional<Pilot> existingPilot = findPilotById(pilot.getId());

        if (existingPilot.isEmpty()) {

            pilot.setId(idGenerator.generate());

            pilotList.add(pilot);
        }
    }

    @Override
    public List<Route> getAllRoutes() {
        return null;
    }

    @Override
    public void saveRoute(Route route) {

    }

    @Override
    public Optional<Flight> findFlightById(Long flightId) {
        return Optional.empty();
    }


    @Override
    public Optional<Vehicle> findVehicleById(Long vehicleId) {
        return null;
    }
}
