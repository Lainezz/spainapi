package com.es.spainapi.exception;

public class DuplicateException extends RuntimeException {
    private static final String DESCRIPTION = "Already exists (400)";

    public DuplicateException(String message) {
        super(String.format("%s. %s", DESCRIPTION, message));
    }
}
