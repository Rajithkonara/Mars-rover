package com.nasa.perseverance.commands;

import com.nasa.perseverance.domain.MarsRover;
import com.nasa.perseverance.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link Move} class.
 */
class MoveTest extends CommandInputs {

    @BeforeEach
    public void setUp() {
        Direction direction = Direction.N;
        marsRover = new MarsRover(plateau, coordinateX, coordinateY, direction);
        command = new Move();
    }

    @Test
    void shouldMoveForwardWhenMoveCommandIsExecuted() {
        command.execute(marsRover);
        assertEquals(3, marsRover.getCoordinateY());
    }
}
