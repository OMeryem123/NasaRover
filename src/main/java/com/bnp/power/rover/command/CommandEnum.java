package com.bnp.power.rover.command;

public enum CommandEnum {
    M(new MoveCommand()),
    L(new TurnLeftCommand()),
    R(new TurnRightCommand());

    private Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return this.command;
    }
}
