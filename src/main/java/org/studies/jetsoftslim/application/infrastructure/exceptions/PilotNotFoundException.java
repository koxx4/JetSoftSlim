package org.studies.jetsoftslim.application.infrastructure.exceptions;

public class PilotNotFoundException extends RuntimeException {

    public PilotNotFoundException() {
    }

    public PilotNotFoundException(String message) {
        super(message);
    }
}
