import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.studies.jetsoftslim.application.infrastructure.InMemoryRepositoryTest;
import org.studies.jetsoftslim.application.infrastructure.RepositoriesTest;
import org.studies.jetsoftslim.application.infrastructure.RouteBasedFlightNameGeneratorTest;
import org.studies.jetsoftslim.application.infrastructure.ServicesTest;
import org.studies.jetsoftslim.controller.ControllersTest;
import org.studies.jetsoftslim.controller.FlightControllerTest;

@RunWith(Categories.class)
@Categories.IncludeCategory({ControllersTest.class, ServicesTest.class, RepositoriesTest.class})
@Categories.SuiteClasses({
        FlightControllerTest.class,
        RouteBasedFlightNameGeneratorTest.class,
        InMemoryRepositoryTest.class
})
public class SuiteTest {
}
