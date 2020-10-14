package com.nasa.perseverance.domain;

import lombok.Getter;

@Getter
public class Plateau {

    private static final int LOWER_BOUND_X = 0;
    private static final int LOWER_BOUND_Y = 0;
    private final int upperBoundX;
    private final int upperBoundY;

    public Plateau(int upperBoundX, int upperBoundY) {
        this.upperBoundX = upperBoundX;
        this.upperBoundY = upperBoundY;
    }

    /**
     * Validate plateau inputs
     *
     * @param coordinateX x
     * @param coordinateY y
     * @return boolean
     */
    public boolean isInvalidCoordinates(int coordinateX, int coordinateY) {
        return coordinateX < 0 || coordinateY < 0;
    }

    /**
     * Check rover is withine the plateau
     *
     * @param roverCoordinateX x
     * @param roverCoordinateY y
     * @return boolean
     */
    public boolean isInvalidRoverLocation(int roverCoordinateX, int roverCoordinateY) {
        return roverCoordinateX > this.upperBoundX || roverCoordinateY > this.upperBoundY;
    }
}
