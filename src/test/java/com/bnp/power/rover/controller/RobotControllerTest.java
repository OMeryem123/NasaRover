package com.bnp.power.rover.controller;

import com.bnp.power.rover.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RobotControllerTest {
    @Test
    public void constructorTest() {
        //given
        RobotController robotController;
        //when
        robotController = new RobotController(null, null);
        //then
        assertEquals(new ArrayList<Robot>(), robotController.getRobots());
        assertEquals(new ArrayList<String>(), robotController.getInstructions());
    }
    @Test
    public void runRobotsTest() {
        //given
        Robot rover = new Rover(new Position(1,2), Direction.NORTH);
        rover.setPlateau(new Plateau(5,5));
        List<Robot> robots = new ArrayList();
        robots.add(rover);
        List<String> instructions = new ArrayList();
        instructions.add("LMLMLMLMM");
        RobotController robotController = new RobotController(robots, instructions);
        //when
        robotController.runRobots();
        //then
        assertEquals(1, robotController.getRobots().get(0).getPosition().getX());
        assertEquals(3, robotController.getRobots().get(0).getPosition().getY());
        assertEquals(Direction.NORTH, robotController.getRobots().get(0).getDirection());
    }
}
