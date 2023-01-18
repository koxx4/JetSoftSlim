package org.studies.jetsoftslim.application.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.studies.jetsoftslim.application.FlightNameGenerator;
import org.studies.jetsoftslim.model.FlightForm;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RouteBasedFlightNameGeneratorTest {

    private FlightNameGenerator flightNameGenerator;

    @BeforeEach
    void setUp() {

        flightNameGenerator = new RouteBasedFlightNameGenerator();
    }

    @ParameterizedTest
    @MethodSource("flightFormsWithRoutes")
    void shouldCreateValidFlightName(FlightForm flightForm, String expected) {

        String result = flightNameGenerator.generateForFlight(flightForm);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldThrowExceptionWhenFormIsNull() {

        FlightForm form = null;

        assertThatIllegalArgumentException().isThrownBy(() ->{
            flightNameGenerator.generateForFlight(form);
        });
    }

    @Test
    void shouldThrowExceptionWhenFormHasEmptyRouteStrings() {

        FlightForm form = new FlightForm();
        form.setSourceCity(" ");
        form.setDestinationCity("Rzym");

        assertThatIllegalArgumentException().isThrownBy(() ->{
            flightNameGenerator.generateForFlight(form);
        });
    }

    private static Stream<Arguments> flightFormsWithRoutes() {

        FlightForm form1 = new FlightForm();
        form1.setSourceCity("Warszawa");
        form1.setDestinationCity("Rzym");

        FlightForm form2 = new FlightForm();
        form2.setSourceCity("Berlin");
        form2.setDestinationCity("Madryt");

        FlightForm form3 = new FlightForm();
        form3.setSourceCity("Berlin");
        form3.setDestinationCity("Rzym");

        return Stream.of(
                Arguments.of(form1, "WARRZY001"),
                Arguments.of(form2, "BERMAD001"),
                Arguments.of(form3, "BERRZY001")
        );
    }
}