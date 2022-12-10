package org.studies.jetsoftslim.controller;

import org.studies.jetsoftslim.application.FlightRepository;
import org.studies.jetsoftslim.application.ReservationNumberGenerator;
import org.studies.jetsoftslim.application.ReservationRepository;
import org.studies.jetsoftslim.model.Reservation;

import java.util.List;

public class ReservationController {

    private ReservationRepository reservationRepository;
    private FlightRepository flightRepository;
    private ReservationNumberGenerator reservationNumberGenerator;

    public ReservationController(ReservationRepository reservationRepository,
                                 FlightRepository flightRepository,
                                 ReservationNumberGenerator reservationNumberGenerator) {
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
        this.reservationNumberGenerator = reservationNumberGenerator;
    }

    public String addReservation(String firstName, String lastName, CharSequence password, Long flightId) {
        return null;
    }

    public boolean deleteReservation(String firstName, String lastName, CharSequence password, String reservationNumber) {
        return true;
    }

    public boolean isReservationExisting(String reservationNumber) {
        return true;
    }

    public List<Reservation> listReservationForFlight(Long flightId) {
        return null;
    }
}
