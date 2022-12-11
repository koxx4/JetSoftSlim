package org.studies.jetsoftslim.model;

import org.studies.jetsoftslim.application.Entity;

public class Pilot implements Entity {

    private Long id;
    private String firstName;
    private String lastName;
    private int hoursOfExperience;

    public Pilot(String firstName, String lastName, int hoursOfExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursOfExperience = hoursOfExperience;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHoursOfExperience() {
        return hoursOfExperience;
    }

    public void setHoursOfExperience(int hoursOfExperience) {
        this.hoursOfExperience = hoursOfExperience;
    }
}
