package com.nasa.perseverance.util;

import com.nasa.perseverance.commands.Command;
import com.nasa.perseverance.domain.MarsRover;
import com.nasa.perseverance.domain.Plateau;
import com.nasa.perseverance.enums.Commands;
import com.nasa.perseverance.enums.Direction;
import com.nasa.perseverance.exception.PerseveranceException;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {

    private static final String STRING_SEPARATOR = " ";

    private CommandLineParser() {
    }

    /**
     * Set the plateau coordinates
     *
     * @param plateau plateau
     * @return plateau
     */
    public static Plateau plateauInputs(String plateau) {
        String[] inputs = plateau.split(STRING_SEPARATOR);
        return new Plateau(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
    }

    /**
     * Set the rover attributes
     *
     * @param position position
     * @param plateau  plateau
     * @return mars rover
     */
    public static MarsRover getRoverPositionInput(String position, Plateau plateau) {
        String[] inputs = position.split(STRING_SEPARATOR);
        Direction direction = Direction.valueOf(inputs[2]);
        return new MarsRover(plateau, Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), direction);

    }

    /**
     * Set the command list
     *
     * @param command command
     * @return commands
     */
    public static List<Command> getCommandsInput(String command) {
        try {
            char[] inputs = command.toCharArray();
            ArrayList<Command> commandArrayList = new ArrayList<>();
            for (char character : inputs) {
                Command currentCommand = Commands.valueOf(Character.toString(character)).getCommand();
                commandArrayList.add(currentCommand);
            }
            return commandArrayList;
        } catch (IllegalArgumentException e) {
            throw new PerseveranceException("Invalid Command");
        }
    }
}
