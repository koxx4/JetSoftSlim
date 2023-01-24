package org.studies.jetsoftslim.mocked;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;
import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.infrastructure.GlobalEntityIdGenerator;
import org.studies.jetsoftslim.application.infrastructure.InMemoryFlightRepository;
import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.Pilot;
import org.studies.jetsoftslim.model.Route;
import org.studies.jetsoftslim.model.Vehicle;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryRepositoryMockedTest {

    @Tested
    private InMemoryFlightRepository flightRepository;

    @Injectable
    private EntityIdGenerator entityIdGenerator;

    private Flight flight1;
    private Flight flight2;
    @Before
    public void setUp() {

        Pilot pilot1 = new Pilot("Piotrek", "Wilczek", 1000);
        Pilot pilot2 = new Pilot("Kacper", "Krupka", 2137);
        Vehicle vehicle1 = new Vehicle("Pandziocha", 56);
        Vehicle vehicle2 = new Vehicle("AjrBas", 150);
        Route route1 = new Route("Bobry", "Berlin");

        flight1 = new Flight(List.of(pilot1), vehicle1, "BOBBER001", route1, ZonedDateTime.now(), ZonedDateTime.now().plusHours(3));
        flight2 = new Flight(List.of(pilot2), vehicle2, "BOBBER002", route1, ZonedDateTime.now().plusHours(1), ZonedDateTime.now().plusHours(6));
    }

    @Test
    public void verifyGettingAllFlightFromRepository() {

        new Expectations() {{
           entityIdGenerator.generate(); result = 1L;
        }};

        flightRepository.save(flight1);

        new Verifications() {{
            entityIdGenerator.generate();
        }};

        var flights = flightRepository.getAll();

        assertThat(flights).containsOnly(flight1);
    }
}
