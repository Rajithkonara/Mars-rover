package com.nasa.perseverance.util;

import com.nasa.perseverance.commands.Command;
import com.nasa.perseverance.domain.MarsRover;
import com.nasa.perseverance.domain.Plateau;
import com.nasa.perseverance.enums.Commands;
import com.nasa.perseverance.enums.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandLineUtilTest {

    @Test
    void shouldGetPlateauInputs() {
        String plateauInput = "5 5";
        Plateau plateau = CommandLineUtil.plateauInputs(plateauInput);
        assertEquals(5, plateau.getUpperBoundX());
        assertEquals(5, plateau.getUpperBoundY());
    }

    @Test
    void shouldGetRoverPositionInputs() {
        String position = "1 2 N";
        Plateau plateau = new Plateau(5, 5);
        MarsRover roverPositionInput = CommandLineUtil.getRoverPositionInput(position, plateau);
        assertEquals(1, roverPositionInput.getCoordinateX());
        assertEquals(2, roverPositionInput.getCoordinateY());
        assertEquals(Direction.N.name(), roverPositionInput.getDirection().name());
    }

    @Test
    void shouldGetCommandInputs() {
        String command = "L";
        List<Command> commandsInput = CommandLineUtil.getCommandsInput(command);
        assertEquals(Commands.L.getCommand(), commandsInput.get(0));
    }

    @Test
    void shouldThrowExceptionForWrongCommandInput() {
        final String command = "B";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Commands.valueOf(command);
        });
    }
}
