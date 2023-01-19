package org.studies.jetsoftslim.model;

import org.studies.jetsoftslim.application.Entity;

public class Vehicle implements Entity {

    private Long id;
    private String modelName;
    private int maxPassengers;
    private VehicleStatus vehicleStatus;

    public Vehicle(String modelName, int maxPassengers) {

        this.modelName = modelName;
        this.maxPassengers = maxPassengers;
        this.vehicleStatus = VehicleStatus.NEW;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void markAsAssignedToFlight() {
        this.vehicleStatus = VehicleStatus.ASSIGNED_TO_FLIGHT;
    }

    public void setIsInRepair() {
        this.vehicleStatus = VehicleStatus.IN_REPAIR;
    }

    public void setIsInFlight() {
        this.vehicleStatus = VehicleStatus.IN_FLIGHT;
    }

    public void markAsReadyToBeAssignedToFlight() {
        this.vehicleStatus = VehicleStatus.READY_TO_BE_ASSIGNED;
    }

    public boolean canBeAssignedToFlight() {
        return this.vehicleStatus == VehicleStatus.READY_TO_BE_ASSIGNED;
    }

    public VehicleStatus getStatus() {
        return this.vehicleStatus;
    }
}
