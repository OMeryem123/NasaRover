package com.bnp.power.rover.view;

import com.bnp.power.rover.model.Robot;

import java.util.List;

public class RobotView {
    private List<Robot> robots;
    public RobotView(List<Robot> robots) {
        this.robots = robots;
    }
    public void show() {
        this.robots.forEach(robot -> System.out.println(robot.toString()));
    }
}
