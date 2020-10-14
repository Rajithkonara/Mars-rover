package com.nasa.perseverance.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PlateauTest {

    @Test
    public void shouldReturnFalseWhenPlateauCoordinatesAreNegative() {
        Plateau plateau = new Plateau(-5, 5);
        assertTrue(plateau.isInvalidCoordinates(plateau.getUpperBoundX(), plateau.getUpperBoundY()));
    }

    @Test
    public void shouldReturnFalseWhenRoverIsOutOfPlateau() {
        Plateau plateau = new Plateau(5, 5);
        assertTrue(plateau.isInvalidRoverLocation(6, 2));
    }
}
