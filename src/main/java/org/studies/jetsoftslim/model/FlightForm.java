package org.studies.jetsoftslim.model;

import java.time.ZonedDateTime;

public class FlightForm {

    private Long assignedPilotId;
    private Long assignedVehicleId;
    private String flightName;
    private String destinationCity;
    private String sourceCity;
    private ZonedDateTime departureDate;
    private ZonedDateTime arrivalDate;

    public Long getAssignedPilotId() {
        return assignedPilotId;
    }

    public void setAssignedPilotId(Long assignedPilotId) {
        this.assignedPilotId = assignedPilotId;
    }

    public Long getAssignedVehicleId() {
        return assignedVehicleId;
    }

    public void setAssignedVehicleId(Long assignedVehicleId) {
        this.assignedVehicleId = assignedVehicleId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
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
}
