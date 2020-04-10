package com.bnp.power.rover.command;

import com.bnp.power.rover.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnLeftCommandTest {
    private Robot robot;
    private Command turnLeft;
    private Plateau plateau;
    private Position position;
    @Before
    public void setup() {
        this.position = new Position(0, 0);
        this.plateau = new Plateau(4, 4);
        this.robot = new Rover();
        this.robot.setPlateau(this.plateau);
        this.robot.setPosition(this.position);
        this.turnLeft = new TurnLeftCommand();
        this.turnLeft.setRobot(robot);
    }

    @Test
    public void turnLeftNorthTest() {
        //given
        robot.setDirection(Direction.NORTH);
        //when
        turnLeft.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }
    @Test
    public void turnLeftSouthTest() {
        //given
        robot.setDirection(Direction.SOUTH);
        //when
        turnLeft.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }
    
    @Test
    public void turnLeftWestTest() {
        //given
        robot.setDirection(Direction.WEST);
        //when
        turnLeft.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }
   
    @Test
    public void turnLeftEastTest() {
        //given
        robot.setDirection(Direction.EAST);
        //when
        turnLeft.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }


    @After
    public void tearDown() {
        this.position = null;
        this.robot = null;
        this.turnLeft = null;
        this.plateau = null;
    }
}
