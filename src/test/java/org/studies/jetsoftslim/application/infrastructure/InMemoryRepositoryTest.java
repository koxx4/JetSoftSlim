package org.studies.jetsoftslim.application.infrastructure;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.studies.jetsoftslim.application.EntityIdGenerator;
import org.studies.jetsoftslim.application.Repository;
import org.studies.jetsoftslim.model.Flight;
import org.studies.jetsoftslim.model.Pilot;
import org.studies.jetsoftslim.model.Route;
import org.studies.jetsoftslim.model.Vehicle;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import static org.junit.Assert.*;

@Category(RepositoriesTest.class)
public class InMemoryRepositoryTest {

    private InMemoryFlightRepository flightRepository;

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

        EntityIdGenerator generator = new GlobalEntityIdGenerator();

        flightRepository = new InMemoryFlightRepository(generator);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }

    @Test
    public void verifyGettingAllFlightFromRepository() {

        var flights = flightRepository.getAll();

        assertThat(flights).hasSize(2);
        assertThat(flights).contains(flight1, flight2);
    }

    @Test
    public void verifyDeletingFlightFromRepository() {

        flightRepository.deleteById(flight1.getId());

        var flights = flightRepository.getAll();

        assertThat(flights).doesNotContain(flight1);
        assertThat(flights).hasSize(1);
    }

}