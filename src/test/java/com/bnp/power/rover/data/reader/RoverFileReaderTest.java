package com.bnp.power.rover.data.reader;

import com.bnp.power.rover.model.Direction;
import com.bnp.power.rover.model.Robot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RoverFileReaderTest {
    private DataReader dataReader;

    @Before
    public void setUp() {
        dataReader = new RoverFileReader("C:\\Users\\Meryem\\Desktop\\prf\\robotRover\\src\\test\\resources\\Input.txt");
    }

    @Test
    public void validGetRobotsTest() {

        try {
            //when
            List<Robot> robots = dataReader.getRobots();
            //then
            assertEquals(2,robots.size());
            assertEquals(1,robots.get(0).getPosition().getX());
            assertEquals(5,robots.get(0).getPosition().getY());
            assertEquals(Direction.NORTH,robots.get(0).getDirection());
        } catch (Exception e) {
            assertTrue(false);
        }

    }
    @Test
    public void validGetInstructionsTest() {

        try {
            //when
            List<String> instructions = dataReader.getInstructions();
            //then
            assertEquals(2,instructions.size());
            assertEquals("LMLMLMLMM",instructions.get(0));
        } catch (Exception e) {
            fail("bad");
        }

    }
    @After
    public void tearDown(){
        this.dataReader = null;
    }

}
