package org.studies.jetsoftslim.controller;

import org.apache.commons.lang3.StringUtils;
import org.studies.jetsoftslim.application.FlightNumberGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.application.infrastructure.exceptions.PilotNotFoundException;
import org.studies.jetsoftslim.application.infrastructure.exceptions.VehicleNotFoundException;
import org.studies.jetsoftslim.model.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

public class FlightController {

    private final Repository<Flight> flightRepository;
    private final Repository<Pilot> pilotRepository;
    private final Repository<Vehicle> vehicleRepository;
    private final FlightNumberGenerator flightNumberGenerator;
    private final FlightFormValidator flightFormValidator;

    public FlightController(Repository<Flight> flightRepository,
                            Repository<Pilot> pilotRepository,
                            Repository<Vehicle> vehicleRepository,
                            FlightNumberGenerator flightNumberGenerator,
                            FlightFormValidator flightFormValidator) {

        this.flightRepository = flightRepository;
        this.pilotRepository = pilotRepository;
        this.vehicleRepository = vehicleRepository;
        this.flightNumberGenerator = flightNumberGenerator;
        this.flightFormValidator = flightFormValidator;
    }

    public void saveFlight(FlightForm flightForm) {

        ValidationResult validationResult = flightFormValidator.validate(flightForm);

        if (validationResult.hasErrors()) {

            throw new IllegalArgumentException("Validation of flight form failed! " + validationResult.getMessage());
        }

        Route route = new Route(flightForm.getSourceCity(), flightForm.getDestinationCity());

        Vehicle vehicle = vehicleRepository.findById(flightForm.getAssignedVehicleId())
                .filter(Vehicle::canBeAssignedToFlight)
                .orElseThrow(VehicleNotFoundException::new);

        List<Pilot> pilots = flightForm.getAssignedPilotIds().stream()
                .map(pilotRepository::findById)
                .map(optionalPilot -> optionalPilot.orElseThrow(PilotNotFoundException::new))
                .collect(toList());

        String flightName = flightForm.getFlightName();

        if (StringUtils.isBlank(flightName)) {

            flightName = flightNumberGenerator.generate(flightForm);
        }

        Flight flight = new Flight(
                pilots,
                vehicle,
                flightName,
                route,
                flightForm.getDepartureDate(),
                flightForm.getArrivalDate()
        );

        flightRepository.save(flight);
    }

    public List<Flight> listFlights(FlightFilterForm flightFilterForm) {

        String flightName = flightFilterForm.getFlightName();
        String sourceCity = flightFilterForm.getSourceCityName();
        String destinationCity =  flightFilterForm.getDestinationCityName();
        ZonedDateTime departureDate = flightFilterForm.getDepartureDate();
        ZonedDateTime arrivalDate = flightFilterForm.getArrivalDate();
        Boolean active = flightFilterForm.isActive();
        String vehicleModelName = flightFilterForm.getVehicleModelName();

        return flightRepository.getAll().stream()
                .filter(flight -> filterByFlightName(flight, flightName))
                .filter(flight -> filterBySourceCity(flight, sourceCity))
                .filter(flight -> filterByDestinationCity(flight, destinationCity))
                .filter(flight -> filterByActive(flight, active))
                .filter(flight -> filterByVehicleModelName(flight, vehicleModelName))
                .filter(flight -> filterByDepartureDate(flight, departureDate))
                .filter(flight -> filterByArrivalDate(flight, arrivalDate))
                .toList();
    }

    public Optional<Flight> findFlightByNumber(String flightNumber) {

        return flightRepository.getAll().stream()
                .filter(flight -> flight.getFlightName().equals(flightNumber))
                .findFirst();
    }

    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }

    private boolean filterByFlightName(Flight flight, String flightName) {
        return flight.getFlightName().equals(flightName) || isNull(flightName);
    }

    private boolean filterBySourceCity(Flight flight, String source) {
        return flight.getRoute().getSourceCityName().equals(source) || isNull(source);
    }

    private boolean filterByDestinationCity(Flight flight, String destination) {
        return flight.getRoute().getDestinationCityName().equals(destination) || isNull(destination);
    }

    private boolean filterByVehicleModelName(Flight flight, String vehicleModelName) {
        return flight.getAssignedVehicle().getModelName().equals(vehicleModelName) || isNull(vehicleModelName);
    }

    private boolean filterByDepartureDate(Flight flight, ZonedDateTime departureDate) {
        return flight.getDepartureDate().equals(departureDate) || isNull(departureDate);
    }

    private boolean filterByArrivalDate(Flight flight, ZonedDateTime arrivalDate) {
        return flight.getArrivalDate().equals(arrivalDate) || isNull(arrivalDate);
    }

    private boolean filterByActive(Flight flight, Boolean active) {

        if (isNull(active))
            return true;

        return flight.isActive();
    }
}
