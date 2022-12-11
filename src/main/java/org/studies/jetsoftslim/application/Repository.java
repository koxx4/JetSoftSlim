package org.studies.jetsoftslim.application;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Entity> {

    void save(T entity);

    Optional<T> findById(Long id);

    void deleteById(Long id);

    List<T> getAll();
}
