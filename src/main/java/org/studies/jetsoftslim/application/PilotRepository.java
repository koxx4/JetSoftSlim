package org.studies.jetsoftslim.application;

import org.studies.jetsoftslim.model.Reservation;

import java.util.List;

public interface PilotRepository {

    void savePilot(Reservation reservation);
    void deletePilot(Long reservationId);
    List<Reservation> getAllPilots();
}
