package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.model.Pilot;

public class InMemoryPilotRepository extends InMemoryRepository<Pilot> implements Repository<Pilot> {

    public InMemoryPilotRepository(EntityIdGenerator idGenerator) {

        super(idGenerator);
    }
}
