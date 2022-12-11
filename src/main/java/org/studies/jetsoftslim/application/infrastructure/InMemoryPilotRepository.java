package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.FlightRepository;
import org.studies.jetsoftslim.model.Pilot;

public class InMemoryPilotRepository extends InMemoryRepository<Pilot> implements FlightRepository {

    private EntityIdGenerator idGenerator;

    public InMemoryPilotRepository(EntityIdGenerator idGenerator) {

        super(idGenerator);

        this.idGenerator = idGenerator;
    }
}
