package org.studies.jetsoftslim.model;

import org.studies.jetsoftslim.application.Entity;

public class Route implements Entity {

    private String sourceCityName;
    private String destinationCityName;

    public Route(String sourceCityName, String destinationCityName) {
        this.sourceCityName = sourceCityName;
        this.destinationCityName = destinationCityName;
    }

//    @Override
//    public boolean equals(Object o) {
//
//    }

//    @Override
//    public int hashCode() {
//
//    }

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
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}
