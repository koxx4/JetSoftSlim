package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.application.infrastructure.*;
import org.studies.jetsoftslim.controller.FlightController;
import org.studies.jetsoftslim.controller.FlightFormValidator;
import org.studies.jetsoftslim.controller.ReservationController;
import org.studies.jetsoftslim.model.*;

public class Program {

    private final Repository<Flight> flightRepository;
    private final Repository<Pilot> pilotRepository;
    private final Repository<Vehicle> vehicleRepository;
    private final Repository<Reservation> reservationRepository;
    private final FlightController flightController;
    private final ReservationController reservationController;
    private final EntityIdGenerator entityIdGenerator;
    private final FlightNumberGenerator flightNumberGenerator;
    private final ReservationNumberGenerator reservationNumberGenerator;
    private final FlightFormValidator flightFormValidator;

    public static void main(String[] args) {

        new Program();
    }

    private Program() {

        entityIdGenerator = new GlobalEntityIdGenerator();
        flightNumberGenerator = new CityBasedFlightNumberGenerator();
        flightFormValidator = new FlightFormValidator();
        reservationNumberGenerator = new ReservationNumberGenerator();

        flightRepository = new InMemoryFlightRepository(entityIdGenerator);
        pilotRepository = new InMemoryPilotRepository(entityIdGenerator);
        vehicleRepository = new InMemoryVehicleRepository(entityIdGenerator);
        reservationRepository = new InMemoryReservationRepository(entityIdGenerator);

        flightController = new FlightController(
                flightRepository,
                pilotRepository,
                vehicleRepository,
                flightNumberGenerator,
                flightFormValidator
                );

        reservationController = new ReservationController(
                reservationRepository,
                flightRepository,
                reservationNumberGenerator);

        generatePilots();
        generateVehicles();
        generateFlights();
        generateReservations();
        showFlightsAndReservations();
    }

    public void generatePilots() {

        Pilot pilot1 = new Pilot("Piotr", "Wilk", 6900);

        pilotRepository.save(pilot1);
    }

    public void generateVehicles() {

    }

    public void generateFlights() {

    }

    public void generateReservations() {

    }

    public void showFlightsAndReservations() {

    }
}