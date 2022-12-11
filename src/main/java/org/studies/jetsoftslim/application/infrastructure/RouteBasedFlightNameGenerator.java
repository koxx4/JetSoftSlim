package org.studies.jetsoftslim.application.infrastructure;

import org.studies.jetsoftslim.application.FlightNameGenerator;
import org.studies.jetsoftslim.model.FlightForm;

import static org.apache.commons.lang3.StringUtils.leftPad;

public class RouteBasedFlightNameGenerator implements FlightNameGenerator {

    private static long counter = 1;

    @Override
    public String generateForFlight(FlightForm flightForm) {

        String sourceCity = flightForm.getSourceCity();
        String destinationCity = flightForm.getDestinationCity();

        String sourceCityCode = sourceCity.substring(0, 3).toUpperCase();

        String destinationCityCode = destinationCity.substring(0, 3).toUpperCase();

        String flightNumber = Long.toString(counter);

        flightNumber = leftPad(flightNumber, 3, '0');

        StringBuilder flightNameBuilder = new StringBuilder()
                .append(sourceCityCode)
                .append(destinationCityCode)
                .append(flightNumber);

        return flightNameBuilder.toString();
    }
}
