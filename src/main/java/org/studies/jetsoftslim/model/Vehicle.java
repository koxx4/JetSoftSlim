package org.studies.jetsoftslim.model;

public class Vehicle {

    private Long id;
    private String modelName;
    private int maxPassengers;

    public Vehicle(String modelName, int maxPassengers) {
        this.modelName = modelName;
        this.maxPassengers = maxPassengers;
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
}
