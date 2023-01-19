package org.studies.jetsoftslim.controller;

import org.studies.jetsoftslim.model.FlightForm;

public class FlightFormValidator {

    public ValidationResult validate(FlightForm flightForm) {

        if (flightForm.getDepartureDate().isAfter(flightForm.getArrivalDate())) {

            return new ValidationResult(true, "Data odlotu jest po dacie przylotu");
        }

        return new ValidationResult(false, "");
    }
}
