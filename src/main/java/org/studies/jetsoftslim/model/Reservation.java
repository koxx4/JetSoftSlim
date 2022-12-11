package org.studies.jetsoftslim.model;

import org.studies.jetsoftslim.application.Entity;

public class Reservation implements Entity {

    private Long id;
    private String clientFirstName;
    private String clientLastName;
    private CharSequence clientPassword;
    private String number;
    private Flight flight;

    public Reservation(String clientFirstName,
                       String clientLastName,
                       CharSequence clientPassword,
                       Flight flight) {
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.clientPassword = clientPassword;
        this.flight = flight;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public CharSequence getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(CharSequence clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
