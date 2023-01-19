package org.studies.jetsoftslim.mocked;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.studies.jetsoftslim.application.FlightNumberGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.controller.FlightController;
import org.studies.jetsoftslim.controller.FlightFormValidator;
import org.studies.jetsoftslim.controller.ValidationResult;
import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.FlightForm;
import org.studies.jetsoftslim.model.Pilot;
import org.studies.jetsoftslim.model.Vehicle;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;

@Category(MockedTest.class)
public class FlightControllerMockedTest {

    @Tested
    private FlightController flightController;

    @Injectable
    private Repository<Flight> flightRepository;

    @Injectable
    private Repository<Pilot> pilotRepository;

    @Injectable
    private Repository<Vehicle> vehicleRepository;

    @Injectable
    private FlightNumberGenerator flightNumberGenerator;

    @Injectable
    private FlightFormValidator flightFormValidator;

    @Test
    public void testSaveFlightWithValidInput() {
        FlightForm flightForm = new FlightForm();
        flightForm.setSourceCity("New York");
        flightForm.setDestinationCity("London");
        flightForm.setAssignedVehicleId(1);
        flightForm.setAssignedPilotIds(Arrays.asList(1L, 2L));
        flightForm.setDepartureDate(ZonedDateTime.now());
        flightForm.setArrivalDate(ZonedDateTime.now().plusHours(8));

        ValidationResult validationResult = new ValidationResult();
        validationResult.setValid(true);

        new Expectations() {{
            flightFormValidator.validate(flightForm);
            result = validationResult;

            vehicleRepository.findById(1);
            result = Optional.of(new Vehicle());

            pilotRepository.findById(1);
            result = Optional.of(new Pilot());

            pilotRepository.findById(2);
            result = Optional.of(new Pilot());
        }};

        flightController.saveFlight(flightForm);

        new Expectations() {{
            flightRepository.save(any);
            times = 1;
        }};
    }
}
