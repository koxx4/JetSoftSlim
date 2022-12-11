package org.studies.jetsoftslim.model;

import java.time.ZonedDateTime;

public class FlightFilterForm {

    private String flightName;
    private String destinationCityName;
    private String sourceCityName;
    private ZonedDateTime departureDate;
    private ZonedDateTime arrivalDate;
    private Boolean active;
    private String vehicleModelName;

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getDestinationCityName() {
        return destinationCityName;
    }

    public void setDestinationCityName(String destinationCityName) {
        this.destinationCityName = destinationCityName;
    }

    public String getSourceCityName() {
        return sourceCityName;
    }

    public void setSourceCityName(String sourceCityName) {
        this.sourceCityName = sourceCityName;
    }

    public ZonedDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(ZonedDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public ZonedDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(ZonedDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }
}
