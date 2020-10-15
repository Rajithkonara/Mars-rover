package com.nasa.perseverance.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link Plateau} class.
 */
class PlateauTest {

    @Test
    void shouldReturnFalseWhenPlateauCoordinatesAreNegative() {
        Plateau plateau = new Plateau(-5, 5);
        assertTrue(plateau.isInvalidCoordinates(plateau.getUpperBoundX(), plateau.getUpperBoundY()));
    }

    @Test
    void shouldReturnFalseWhenRoverIsOutOfPlateau() {
        Plateau plateau = new Plateau(5, 5);
        assertTrue(plateau.isInvalidRoverLocation(6, 2));
    }
}
