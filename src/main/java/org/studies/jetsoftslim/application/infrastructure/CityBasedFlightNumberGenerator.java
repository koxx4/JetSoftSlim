package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.FlightNumberGenerator;
import org.studies.jetsoftslim.model.FlightForm;

public class CityBasedFlightNumberGenerator implements FlightNumberGenerator {

    private Long flightCounter;

    @Override
    public String generate(FlightForm flightForm) {
        return null;
    }
}
