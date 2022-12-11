package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.ReservationRepository;
import org.studies.jetsoftslim.model.Reservation;

import java.util.List;

public class InMemoryReservationRepository extends InMemoryRepository<Reservation> implements ReservationRepository {

    private List<Reservation> reservationList;

    private EntityIdGenerator idGenerator;

    public InMemoryReservationRepository(EntityIdGenerator idGenerator) {
        super(idGenerator);
    }

    @Override
    public void saveReservation(Reservation reservation) {

    }

    @Override
    public void deleteReservation(Long reservationId) {

    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }
}
