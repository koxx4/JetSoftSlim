package org.studies.jetsoftslim.model.flight;

import java.util.Objects;

public class Route {

    private String sourceCityName;
    private String destinationCityName;

    public Route(String sourceCityName, String destinationCityName) {

        this.sourceCityName = sourceCityName;
        this.destinationCityName = destinationCityName;
    }

    public String getSourceCityName() {
        return sourceCityName;
    }

    public void setSourceCityName(String sourceCityName) {
        this.sourceCityName = sourceCityName;
    }

    public String getDestinationCityName() {
        return destinationCityName;
    }

    public void setDestinationCityName(String destinationCityName) {
        this.destinationCityName = destinationCityName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Route route = (Route) o;

        return Objects.equals(sourceCityName, route.sourceCityName) && Objects.equals(destinationCityName, route.destinationCityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceCityName, destinationCityName);
    }
}
