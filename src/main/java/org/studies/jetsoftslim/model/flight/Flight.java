package org.studies.jetsoftslim.model.flight;

import java.time.ZonedDateTime;

public class Flight {

    private FlightId flightId;
    private Long assignedPilotId;
    private Long assignedVehicleId;
    private String flightName;
    private Route route;
    private ZonedDateTime departureDate;
    private ZonedDateTime arrivalDate;
    private boolean active;

    public Flight(
            FlightId flightId,
            Long assignedPilotId,
            Long assignedVehicleId,
            String flightName,
            Route route,
            ZonedDateTime departureDate,
            ZonedDateTime arrivalDate) {

        this.flightId = flightId;
        this.assignedPilotId = assignedPilotId;
        this.assignedVehicleId = assignedVehicleId;
        this.flightName = flightName;
        this.route = route;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public void setFlightId(FlightId flightId) {
        this.flightId = flightId;
    }

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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
