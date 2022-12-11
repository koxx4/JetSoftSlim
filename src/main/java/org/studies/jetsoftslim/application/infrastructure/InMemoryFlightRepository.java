package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.model.Flight;

public class InMemoryFlightRepository extends InMemoryRepository<Flight> implements Repository<Flight> {

    public InMemoryFlightRepository(EntityIdGenerator idGenerator) {

        super(idGenerator);
    }
}
