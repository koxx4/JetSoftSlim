package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.controller.FlightController;
import org.studies.jetsoftslim.controller.ReservationController;
import org.studies.jetsoftslim.model.Pilot;

public class Program {

    private FlightController flightController;
    private FlightRepository flightRepository;
    private ReservationController reservationController;
    private ReservationRepository reservationRepository;

    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public void generatePilots() {
        Pilot pilot1 = new Pilot("Piotr", "Wilk", 6900);

        flightRepository.savePilot(pilot1);
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