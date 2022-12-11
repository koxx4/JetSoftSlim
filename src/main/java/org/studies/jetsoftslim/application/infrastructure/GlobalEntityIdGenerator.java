package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.EntityIdGenerator;

public class GlobalEntityIdGenerator implements EntityIdGenerator {

    private Long globalIdCounter = 0L;

    @Override
    public Long generate() {
        return ++globalIdCounter;
    }
}
