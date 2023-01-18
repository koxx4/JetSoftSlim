package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.FlightNameGenerator;
import org.studies.jetsoftslim.model.FlightForm;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.*;

public class RouteBasedFlightNameGenerator implements FlightNameGenerator {

    private long counter = 1;

    @Override
    public String generateForFlight(FlightForm flightForm) {

        if (isNull(flightForm)) {

            throw new IllegalArgumentException();
        }

        String sourceCity = flightForm.getSourceCity();
        String destinationCity = flightForm.getDestinationCity();

        if (isBlank(sourceCity) || isBlank(destinationCity)) {

            throw new IllegalArgumentException();
        }

        String sourceCityCode = sourceCity.substring(0, 3).toUpperCase();

        String destinationCityCode = destinationCity.substring(0, 3).toUpperCase();

        String flightNumber = Long.toString(counter);

        flightNumber = leftPad(flightNumber, 3, '0');

        String flightNameBuilder = sourceCityCode +
                destinationCityCode +
                flightNumber;

        counter++;

        return flightNameBuilder;
    }
}
