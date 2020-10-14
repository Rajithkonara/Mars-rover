package com.nasa.perseverance.commands;

import com.nasa.perseverance.domain.MarsRover;

public class Move implements Command {

    @Override
    public void execute(MarsRover marsRover) {
        marsRover.move();
    }
}
