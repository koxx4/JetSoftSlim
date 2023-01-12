package org.studies.jetsoftslim.controller;

import org.studies.jetsoftslim.application.FlightNameGenerator;
import org.studies.jetsoftslim.application.FlightRepository;
import org.studies.jetsoftslim.model.FlightForm;
import org.studies.jetsoftslim.model.flight.Flight;
import org.studies.jetsoftslim.model.flight.Route;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class FlightEditController {

    private final FlightRepository flightRepository;
    private final FlightNameGenerator flightNameGenerator;

    public FlightEditController(FlightRepository flightRepository, FlightNameGenerator flightNameGenerator) {

        this.flightRepository = flightRepository;
        this.flightNameGenerator = flightNameGenerator;
    }

    public void createFlight(FlightForm flightForm) {

        String flightName = flightForm.getFlightName();

        if (isBlank(flightName)) {

            flightName = flightNameGenerator.generateForFlight(flightForm);
        }

        Route route = new Route(flightForm.getSourceCity(), flightForm.getDestinationCity());

        Flight flight = new Flight(
                0L,
                0L,
                flightName,
                route,
                flightForm.getDepartureDate(),
                flightForm.getArrivalDate()
        );

        flightRepository.saveFlight(flight);
    }
}
