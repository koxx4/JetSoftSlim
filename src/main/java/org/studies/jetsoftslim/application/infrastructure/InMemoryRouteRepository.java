package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.FlightRepository;
import org.studies.jetsoftslim.model.Flight;

public class InMemoryRouteRepository extends InMemoryRepository<Flight> implements FlightRepository {

    private EntityIdGenerator idGenerator;

    public InMemoryRouteRepository(EntityIdGenerator idGenerator) {

        super(idGenerator);

        this.idGenerator = idGenerator;
    }
}
