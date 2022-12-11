package org.studies.jetsoftslim.model;

import org.studies.jetsoftslim.application.Entity;

import java.time.ZonedDateTime;
import java.util.List;

public class Flight implements Entity {

    private Long id;
    private List<Pilot> assignedPilots;
    private Vehicle assignedVehicle;
    private String flightName;
    private Route route;
    private ZonedDateTime departureDate;
    private ZonedDateTime arrivalDate;
    private boolean active;
    private List<Reservation> reservations;

    public Flight(List<Pilot> assignedPilots,
                  Vehicle assignedVehicle,
                  String flightName,
                  Route route,
                  ZonedDateTime departureDate,
                  ZonedDateTime arrivalDate) {

        this.assignedPilots = assignedPilots;
        this.assignedVehicle = assignedVehicle;
        this.flightName = flightName;
        this.route = route;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<Pilot> getAssignedPilots() {
        return assignedPilots;
    }

    public void setAssignedPilots(List<Pilot> assignedPilots) {
        this.assignedPilots = assignedPilots;
    }

    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(Vehicle assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addPilot(Pilot pilot) {

    }

    public void removePilot(Pilot pilot) {

    }
}
