package org.studies.jetsoftslim.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.FlightNumberGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.application.infrastructure.*;
import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.FlightForm;
import org.studies.jetsoftslim.model.Pilot;
import org.studies.jetsoftslim.model.Vehicle;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.*;

@Category(ControllersTest.class)
public class FlightControllerTest {

    private FlightController flightController;
    private Pilot pilot1;
    private Vehicle vehicle1;
    private Repository<Flight> flightRepository;

    @Before
    public void setUp() {
        EntityIdGenerator generator = new GlobalEntityIdGenerator();
        pilot1 = new Pilot("Piotrek", "Wilczek", 1000);
        vehicle1 = new Vehicle("AjrBas", 150);
        vehicle1.markAsReadyToBeAssignedToFlight();

        flightRepository = new InMemoryFlightRepository(generator);
        Repository<Pilot> pilotRepository = new InMemoryPilotRepository(generator);
        Repository<Vehicle> vehicleRepository = new InMemoryVehicleRepository(generator);
        FlightNumberGenerator flightNumberGenerator = new CityBasedFlightNumberGenerator();
        FlightFormValidator flightFormValidator = new FlightFormValidator();

        pilotRepository.save(pilot1);
        vehicleRepository.save(vehicle1);

        flightController = new FlightController(flightRepository, pilotRepository, vehicleRepository, flightNumberGenerator, flightFormValidator);
    }

    @Test
    public void verifyThrowingErrorWhenDatesAreWrong() {

        var form = new FlightForm();

        form.setDepartureDate(ZonedDateTime.now().plusHours(3));
        form.setArrivalDate(ZonedDateTime.now());

        assertThatIllegalArgumentException().isThrownBy(() -> {
            flightController.saveFlight(form);
        });
    }

    @Test public void verifySavingFlightAndGeneratingFlightName() {

        var form = new FlightForm();

        form.setDepartureDate(ZonedDateTime.now());
        form.setArrivalDate(ZonedDateTime.now().plusHours(3));
        form.setSourceCity("Zabkowice");
        form.setDestinationCity("Radomsko");
        form.setAssignedPilotIds(List.of(pilot1.getId()));
        form.setAssignedVehicleId(vehicle1.getId());

        flightController.saveFlight(form);

        Flight result = flightRepository.getAll().get(0);

        assertThat(result.getDepartureDate()).isEqualTo(form.getDepartureDate());
        assertThat(result.getArrivalDate()).isEqualTo(form.getArrivalDate());
        assertThat(result.getFlightName()).isEqualTo("ZABRAD001");
        assertThat(result.getRoute().getSourceCityName()).isEqualTo(form.getSourceCity());
        assertThat(result.getRoute().getDestinationCityName()).isEqualTo(form.getDestinationCity());
        assertThat(result.getAssignedPilots().stream().map(Pilot::getId)).containsOnly(pilot1.getId());
        assertThat(result.getAssignedVehicle().getId()).isEqualTo(vehicle1.getId());
    }
}