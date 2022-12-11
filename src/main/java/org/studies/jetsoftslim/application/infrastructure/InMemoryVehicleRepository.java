package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.model.Vehicle;

public class InMemoryVehicleRepository extends InMemoryRepository<Vehicle> implements Repository<Vehicle> {

    public InMemoryVehicleRepository(EntityIdGenerator idGenerator) {

        super(idGenerator);
    }
}
