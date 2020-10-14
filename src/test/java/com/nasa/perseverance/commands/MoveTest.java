package com.nasa.perseverance.commands;

import com.nasa.perseverance.domain.MarsRover;
import com.nasa.perseverance.domain.Plateau;
import com.nasa.perseverance.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveTest {

    protected final Plateau plateau = new Plateau(5, 5);
    protected int coordinateX = 1;
    protected int coordinateY = 2;
    protected Command command;
    protected MarsRover marsRover;

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
