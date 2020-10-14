package com.nasa.perseverance.exception;

/**
 * Mars Rover OutOfBoundException
 */
public class MarsRoverOutOfBoundException extends PerseveranceException {

    public MarsRoverOutOfBoundException() {
        super("Rover is trying to navigate outside the plateau");
    }

}

