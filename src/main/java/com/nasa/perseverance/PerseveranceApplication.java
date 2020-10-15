package com.nasa.perseverance;

import com.nasa.perseverance.commands.Command;
import com.nasa.perseverance.domain.MarsRover;
import com.nasa.perseverance.domain.Plateau;
import com.nasa.perseverance.exception.MarsRoverOutOfBoundException;
import com.nasa.perseverance.exception.PerseveranceException;
import com.nasa.perseverance.util.CommandLineParser;

import java.util.List;
import java.util.Scanner;

public class PerseveranceApplication {

    private static final String QUIT = "q";

    public static void main(String[] args) {

        System.out.println("Please enter the rover instructions ");
        Scanner input = new Scanner(System.in);
        Plateau plateau = CommandLineParser.plateauInputs(input.nextLine());

        if (plateau.isInvalidCoordinates(plateau.getUpperBoundX(), plateau.getUpperBoundY())) {
            throw new PerseveranceException("Plateau coordinates should be positive");
        }

        while (!input.hasNext(QUIT)) {
            MarsRover roverPositionInput = CommandLineParser.getRoverPositionInput(input.nextLine(), plateau);
            if (plateau.isInvalidRoverLocation(roverPositionInput.getCoordinateX(),
                    roverPositionInput.getCoordinateY())) {
                throw new MarsRoverOutOfBoundException();
            }
            List<Command> commandsInput = CommandLineParser.getCommandsInput(input.nextLine());
            roverPositionInput.executeCommands(commandsInput);
            System.out.println(roverPositionInput.getRoverPosition());
        }

        System.out.println("Shutting down .....");
        System.exit(1);
    }
}
