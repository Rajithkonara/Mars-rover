package com.nasa.perseverance.domain;

import com.nasa.perseverance.commands.Command;
import com.nasa.perseverance.enums.Direction;
import lombok.Getter;

import java.util.List;

@Getter
public class MarsRover {

    private final Plateau plateau;
    private int coordinateX;
    private int coordinateY;
    private Direction direction;

    public MarsRover(Plateau plateau, int coordinateX, int coordinateY, Direction direction) {
        this.plateau = plateau;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.direction = direction;
    }

    public void executeCommands(List<Command> commands) {
        for (Command command : commands)
            command.execute(this);
    }

    public void turnRight() {
        this.direction = this.direction.right();
    }

    public void turnLeft() {
        this.direction = this.direction.left();
    }

    public void move() {
        coordinateX = coordinateX + direction.getPositionOnX();
        coordinateY = coordinateY + direction.getPositionOnY();
    }

    public String getRoverPosition() {
        return coordinateX + " " + coordinateY + " " + getDirection().name();
    }
}
