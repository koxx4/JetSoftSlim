package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.model.Reservation;

import java.util.List;

public interface ReservationRepository {

    void saveReservation(Reservation reservation);
    void deleteReservation(Long reservationId);
    List<Reservation> getAllReservations();
}
