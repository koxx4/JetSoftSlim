package org.studies.jetsoftslim.mocked;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@RunWith(Categories.class)
@Categories.IncludeCategory({MockedTest.class})
@Categories.SuiteClasses({
        FlightControllerMockedTest.class,
        InMemoryRepositoryMockedTest.class
})
public class SuiteMockedTest {
}
