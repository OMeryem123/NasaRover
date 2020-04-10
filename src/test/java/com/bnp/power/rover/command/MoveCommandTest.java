package com.bnp.power.rover.command;


import com.bnp.power.rover.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveCommandTest {
    private Robot robot;
    private Command move;
    private Plateau plateau;

    @Before
    public void setup() {
        plateau = new Plateau(4, 4);
        robot = new Rover();
        robot.setPlateau(this.plateau);
        move = new MoveCommand();
        move.setRobot(robot);
    }

    @Test
    public void moveNorthTest() {
        //given
        Position position = new Position(0, 0);
        robot.setPosition(position);
        robot.setDirection(Direction.NORTH);
        //when
        move.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }
    @Test
    public void moveNorthOutTest() {
        //given
        Position position = new Position(0, 4);
        robot.setPosition(position);
        robot.setDirection(Direction.NORTH);
        //when
        move.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(4, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }
    @Test
    public void moveSouthTest() {
        //given
        Position position = new Position(0, 4);
        robot.setPosition(position);
        robot.setDirection(Direction.SOUTH);
        //when
        move.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }
    @Test
    public void moveSouthOutTest() {
        //given
        Position position = new Position(0, 0);
        robot.setPosition(position);
        robot.setDirection(Direction.SOUTH);
        //when
        move.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }
    @Test
    public void moveWestTest() {
        //given
        Position position = new Position(3, 0);
        robot.setPosition(position);
        robot.setDirection(Direction.WEST);
        //when
        move.execute();
        //then
        assertEquals(2, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }
    @Test
    public void moveWestOutTest() {
        //given
        Position position = new Position(0, 0);
        robot.setPosition(position);
        robot.setDirection(Direction.WEST);
        //when
        move.execute();
        //then
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }
    @Test
    public void moveEastTest() {
        //given
        Position position = new Position(0, 0);
        robot.setPosition(position);
        robot.setDirection(Direction.EAST);
        //when
        move.execute();
        //then
        assertEquals(1, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }
    @Test
    public void moveEastOutTest() {
        //given
        Position position = new Position(4, 0);
        robot.setPosition(position);
        robot.setDirection(Direction.EAST);
        //when
        move.execute();
        //then
        assertEquals(4, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }


    @After
    public void tearDown() {
        this.robot = null;
        this.move = null;
        this.plateau = null;
    }
}
