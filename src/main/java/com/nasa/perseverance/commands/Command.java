package com.nasa.perseverance.commands;

import com.nasa.perseverance.domain.MarsRover;

public interface Command {
    void execute(MarsRover marsRover);
}
