package org.studies.jetsoftslim.mocked;

import mockit.Verifications;
import mockit.integration.junit5.JMockitExtension;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
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

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

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

    Pilot pilot1;
    Vehicle vehicle1;

    @Before
    public void setUp() {

        pilot1 = new Pilot("Piotrek", "Wilczek", 1000);
        vehicle1 = new Vehicle("AjrBas", 150);
        vehicle1.markAsReadyToBeAssignedToFlight();
    }

    @Test
    public void testSaveFlightFromFormShouldNotThrowException() {

        FlightForm flightForm = new FlightForm();
        flightForm.setSourceCity("New York");
        flightForm.setDestinationCity("London");
        flightForm.setAssignedVehicleId(1L);
        flightForm.setAssignedPilotIds(Arrays.asList(1L, 2L));
        flightForm.setDepartureDate(ZonedDateTime.now());
        flightForm.setArrivalDate(ZonedDateTime.now().plusHours(8));

        ValidationResult validationResult = new ValidationResult(false, "");

        new Expectations() {{
            vehicleRepository.findById(anyLong); result = vehicle1;
            pilotRepository.findById(anyLong); result = pilot1;
        }};

        flightController.saveFlight(flightForm);

        new Verifications() {{
            flightFormValidator.validate(withSameInstance(flightForm));
            flightRepository.save(withInstanceOf(Flight.class));
        }};
    }
}
