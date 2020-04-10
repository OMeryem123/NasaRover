package com.bnp.power.rover.exception;

public class FileValidationException extends RuntimeException {
    private final String message;
    public FileValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
