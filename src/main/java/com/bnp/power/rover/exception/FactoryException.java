package com.bnp.power.rover.exception;

public class FactoryException extends RuntimeException {
    private final String message;
    public FactoryException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
