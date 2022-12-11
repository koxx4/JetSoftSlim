package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.controller.FlightController;
import org.studies.jetsoftslim.controller.ReservationController;
import org.studies.jetsoftslim.model.*;

public class Program {

    private Repository<Flight> flightRepository;
    private Repository<Pilot> pilotRepository;
    private Repository<Vehicle> vehicleRepository;
    private Repository<Reservation> reservationRepository;
    private FlightController flightController;
    private ReservationController reservationController;

    public static void main(String[] args) {

        System.out.println("Hello world!");
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