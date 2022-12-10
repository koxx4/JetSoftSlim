package org.studies.jetsoftslim.controller;

import org.studies.jetsoftslim.application.FlightNumberGenerator;
import org.studies.jetsoftslim.application.FlightRepository;
import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.FlightFilterForm;
import org.studies.jetsoftslim.model.FlightForm;

import java.util.List;
import java.util.Optional;

public class FlightController {

    private FlightRepository flightRepository;
    private FlightNumberGenerator flightNumberGenerator;
    private FlightFormValidator flightFormValidator;

    public FlightController(FlightRepository flightRepository,
                            FlightNumberGenerator flightNumberGenerator,
                            FlightFormValidator flightFormValidator) {
        this.flightRepository = flightRepository;
        this.flightNumberGenerator = flightNumberGenerator;
        this.flightFormValidator = flightFormValidator;
    }

    public void saveFlight(FlightForm flightForm) {

    }

    public List<Flight> listFlights(FlightFilterForm flightFilterForm) {
        return null;
    }

    public Optional<Flight> findFlightByNumber(String flightNumber) {
        return null;
    }

    public void deleteFlight(Long flightId) {

    }
}
