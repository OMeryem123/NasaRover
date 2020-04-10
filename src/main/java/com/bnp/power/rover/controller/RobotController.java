package com.bnp.power.rover.controller;

import com.bnp.power.rover.command.Command;
import com.bnp.power.rover.command.CommandEnum;
import com.bnp.power.rover.model.Robot;
import com.bnp.power.rover.view.RobotView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RobotController {
    private List<Robot> robots;
    private List<String> instructions;

    public RobotController(List<Robot> robots, List<String> instructions) {
        this.robots = Objects.requireNonNullElse(robots, new ArrayList<Robot>());
        this.instructions = Objects.requireNonNullElse(instructions, new ArrayList<String>());
    }

    public RobotView runRobots() {
        for(int i = 0; i < this.robots.size(); i++) {
            excuteCommands(i);
        }
        return new RobotView(this.robots);
    }

    private void excuteCommands(int i) {
        char[] instr = this.instructions.get(i).toCharArray();
        for(char instruction: instr) {
            Command command = CommandEnum.valueOf(Character.toString(instruction)).getCommand();
            command.setRobot(robots.get(i));
            command.execute();
        }
    }
    public List<Robot> getRobots() {
        return robots;
    }

    public List<String> getInstructions() {
        return instructions;
    }
}
