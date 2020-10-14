package com.nasa.perseverance.domain;

import com.nasa.perseverance.commands.Command;
import com.nasa.perseverance.commands.Move;
import com.nasa.perseverance.commands.TurnLeft;
import com.nasa.perseverance.commands.TurnRight;
import com.nasa.perseverance.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    protected final Plateau plateau = new Plateau(5, 5);
    protected int coordinateX = 1;
    protected int coordinateY = 2;
    protected Command command;
    protected MarsRover marsRover;


    @BeforeEach
    void setUp() {
        Direction direction = Direction.N;
        marsRover = new MarsRover(plateau, coordinateX, coordinateY, direction);
        command = new Move();
    }

    @Test
    void shouldMoveForward() {
        marsRover.move();
        assertEquals(3, marsRover.getCoordinateY());
    }

    @Test
    void shouldTurnLeft() {
        marsRover.turnLeft();
        assertEquals(Direction.W.name(), marsRover.getDirection().name());
    }

    @Test
    void shouldTurnRight() {
        marsRover.turnRight();
        assertEquals(Direction.E.name(), marsRover.getDirection().name());
    }

    @Test
    void shouldReturnCurrentPosition() {
        String currentPosition = coordinateX + " " + coordinateY++ + " " + Direction.N.name();
        assertEquals(marsRover.getRoverPosition(), currentPosition);
    }

    @Test
    void shouldExecuteCommands() {
        Plateau plateau = new Plateau(5, 5);
        int coordinateX = 1;
        int coordinateY = 2;
        MarsRover marsRover_2;
        Direction direction = Direction.N;
        marsRover_2 = new MarsRover(plateau, coordinateX, coordinateY, direction);
        //LMLMLMLMM
        List<Command> commands = new ArrayList<>();
        commands.add(0, new TurnLeft());
        commands.add(1, new Move());
        commands.add(2, new TurnLeft());
        commands.add(3, new Move());
        commands.add(4, new TurnLeft());
        commands.add(5, new Move());
        commands.add(6, new TurnLeft());
        commands.add(7, new Move());
        commands.add(8, new Move());
        marsRover_2.executeCommands(commands);
        assertEquals(1, marsRover_2.getCoordinateX());
        assertEquals(3, marsRover_2.getCoordinateY());
        assertEquals(Direction.N.name(), marsRover.getDirection().name());
    }


}
