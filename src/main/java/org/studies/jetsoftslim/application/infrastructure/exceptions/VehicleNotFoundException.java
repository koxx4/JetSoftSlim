package org.studies.jetsoftslim.application.infrastructure.exceptions;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException() {
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
