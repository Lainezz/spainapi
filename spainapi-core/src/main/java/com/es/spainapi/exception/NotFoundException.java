package com.es.spainapi.exception;

public class NotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not Found (404)";

    public NotFoundException(String message) {
        super(String.format("%s. %s", DESCRIPTION, message));
    }
}
