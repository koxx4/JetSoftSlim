package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.Entity;
import org.studies.jetsoftslim.application.EntityIdGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

abstract class InMemoryRepository<T extends Entity> {

    protected Map<Long, T> entities;
    protected EntityIdGenerator idGenerator;

    protected InMemoryRepository(EntityIdGenerator idGenerator) {

        this.idGenerator = idGenerator;
        this.entities = new HashMap<>();
    }

    public Optional<T> findById(Long id) {

        return Optional.ofNullable(entities.get(id));
    }

    public void save(T entity) {

        entities.put(entity.getId(), entity);
    }

    public void delete(T entity) {

        entities.remove(entity.getId());
    }
}
