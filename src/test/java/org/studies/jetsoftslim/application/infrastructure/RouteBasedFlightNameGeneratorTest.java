package org.studies.jetsoftslim.application.infrastructure;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.studies.jetsoftslim.application.FlightNameGenerator;
import org.studies.jetsoftslim.model.FlightForm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@RunWith(Parameterized.class)
@Category(ServicesTest.class)
public class RouteBasedFlightNameGeneratorTest {

    private FlightNameGenerator flightNameGenerator;
    @Parameterized.Parameter(0)
    public FlightForm flightFormParameter;
    @Parameterized.Parameter(1)
    public String expectedParameter;

    @Before
    public void setUp() {

        flightNameGenerator = new RouteBasedFlightNameGenerator();
    }

    @Test
    public void shouldCreateValidFlightName() {

        String result = flightNameGenerator.generateForFlight(flightFormParameter);

        assertThat(result).isEqualTo(expectedParameter);
    }

    @Test
    public void shouldThrowExceptionWhenFormIsNull() {

        FlightForm form = null;

        assertThatIllegalArgumentException().isThrownBy(() ->{
            flightNameGenerator.generateForFlight(form);
        });
    }

    @Test
    public void shouldThrowExceptionWhenFormHasEmptyRouteStrings() {

        FlightForm form = new FlightForm();
        form.setSourceCity(" ");
        form.setDestinationCity("Rzym");

        assertThatIllegalArgumentException().isThrownBy(() ->{
            flightNameGenerator.generateForFlight(form);
        });
    }

    @Parameterized.Parameters
    public static Object[][] flightFormsWithRoutes() {

        FlightForm form1 = new FlightForm();
        form1.setSourceCity("Warszawa");
        form1.setDestinationCity("Rzym");

        FlightForm form2 = new FlightForm();
        form2.setSourceCity("Berlin");
        form2.setDestinationCity("Madryt");

        FlightForm form3 = new FlightForm();
        form3.setSourceCity("Berlin");
        form3.setDestinationCity("Rzym");

        return new Object[][] {
            {form1, "WARRZY001"},
            {form2, "BERMAD001"},
            {form3, "BERRZY001"},
        };
    }
}