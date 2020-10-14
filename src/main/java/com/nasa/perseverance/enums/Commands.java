package com.nasa.perseverance.enums;

import com.nasa.perseverance.commands.Command;
import com.nasa.perseverance.commands.Move;
import com.nasa.perseverance.commands.TurnLeft;
import com.nasa.perseverance.commands.TurnRight;
import lombok.Getter;

@Getter
public enum Commands {

    R(new TurnRight()),

    L(new TurnLeft()),

    M(new Move());

    private final Command command;

    Commands(Command command) {
        this.command = command;
    }
}
