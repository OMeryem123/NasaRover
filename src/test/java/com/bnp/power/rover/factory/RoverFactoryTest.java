package com.bnp.power.rover.factory;

import com.bnp.power.rover.exception.FactoryException;
import com.bnp.power.rover.model.Direction;
import com.bnp.power.rover.model.Position;
import com.bnp.power.rover.model.Robot;
import com.bnp.power.rover.model.Rover;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class RoverFactoryTest {
    private RoverFactory roverFactory;

    @Before
    public void setup() {
        roverFactory = new RoverFactory();
    }

    @Test(expected = FactoryException.class)
    public void getNullRoverTest() {
        roverFactory.createRobot(null, new Position(0,0), Direction.NORTH);
    }

    @Test(expected = FactoryException.class)
    public void getUnknowRoverTest() {
        roverFactory.createRobot("azer", new Position(0,0), Direction.NORTH);
    }

    @Test
    public void getRoverTest() {
        //when
        Robot rover = roverFactory.createRobot("rover", new Position(0, 0), Direction.NORTH);
        //then
        assertTrue(rover instanceof Rover);
        assertEquals(0, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @After
    public void tearDown() {
        this.roverFactory = null;
    }
}
