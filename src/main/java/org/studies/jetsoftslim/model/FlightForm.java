package org.studies.jetsoftslim.model;

import java.time.ZonedDateTime;
import java.util.List;

public class FlightForm {

    private List<Long> assignedPilotIds;
    private Long assignedVehicleId;
    private String destinationCity;
    private String sourceCity;
    private String flightName;
    private ZonedDateTime departureDate;
    private ZonedDateTime arrivalDate;

    public List<Long> getAssignedPilotIds() {
        return assignedPilotIds;
    }

    public void setAssignedPilotIds(List<Long> assignedPilotIds) {
        this.assignedPilotIds = assignedPilotIds;
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
}
