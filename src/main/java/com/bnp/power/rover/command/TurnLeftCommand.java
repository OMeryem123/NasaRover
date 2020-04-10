package com.bnp.power.rover.command;

import com.bnp.power.rover.model.Robot;

public class TurnLeftCommand implements Command {
    private Robot robot;
    @Override
    public void execute() {
        robot.turnLeft();
    }

    @Override
    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}
