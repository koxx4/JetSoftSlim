package org.studies.jetsoftslim.controller;

public class ValidationResult {

    private boolean errors;
    private String message;

    public ValidationResult(boolean errors, String message) {
        this.errors = errors;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean hasErrors() {
        return true;
    }
}
