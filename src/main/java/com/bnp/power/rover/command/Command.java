package com.bnp.power.rover.command;

import com.bnp.power.rover.model.Robot;

public interface Command {
    void execute();
    void setRobot(Robot robot);
}
