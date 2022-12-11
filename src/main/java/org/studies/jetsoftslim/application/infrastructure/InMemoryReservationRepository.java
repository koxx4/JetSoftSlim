package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.model.Reservation;

public class InMemoryReservationRepository extends InMemoryRepository<Reservation> implements Repository<Reservation> {

    public InMemoryReservationRepository(EntityIdGenerator idGenerator) {

        super(idGenerator);
    }
}
