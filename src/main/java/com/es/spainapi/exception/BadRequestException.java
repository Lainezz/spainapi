package com.es.spainapi.exception;

public class BadRequestException extends RuntimeException {
    private static final String DESCRIPTION = "Bad Request (400)";

    public BadRequestException(String message) {
        super(String.format("%s. %s", DESCRIPTION, message));
    }
}
