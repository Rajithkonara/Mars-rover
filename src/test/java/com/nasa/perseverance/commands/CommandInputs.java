package com.nasa.perseverance.commands;

import com.nasa.perseverance.domain.MarsRover;
import com.nasa.perseverance.domain.Plateau;

public abstract class CommandInputs {

    protected final Plateau plateau = new Plateau(5, 5);
    protected int coordinateX = 1;
    protected int coordinateY = 2;
    protected Command command;
    protected MarsRover marsRover;

}
