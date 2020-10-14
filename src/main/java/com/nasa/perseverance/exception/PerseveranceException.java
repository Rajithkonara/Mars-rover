package com.nasa.perseverance.exception;

/**
 * Mars Rover Perseverance Exception
 */
public class PerseveranceException extends RuntimeException {

    public PerseveranceException(String errorMessage) {
        super(errorMessage);
    }
}
