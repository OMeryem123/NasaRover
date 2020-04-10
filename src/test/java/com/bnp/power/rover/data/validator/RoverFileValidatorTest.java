package com.bnp.power.rover.data.validator;

import com.bnp.power.rover.model.Plateau;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RoverFileValidatorTest {
    private DataValidator dataValidator;

    @Before
    public void setUp() {
        dataValidator = new RoverFileValidator();
    }

    @Test
    public void validPlateauDimensionTest() {
        //given
        String line = "5 5";
        //when
        Boolean valid = dataValidator.validPlateauDimension(line);
        //then
        assertTrue(valid);
    }
    @Test
    public void invalidPlateauDimensionTest() {
        //given
        String line = "N 5";
        //when
        Boolean valid = dataValidator.validPlateauDimension(line);
        //then
        assertFalse(valid);
    }
    @Test
    public void validRobotsPositionTest() {
        //given
        ArrayList<String> robotsPosition = new ArrayList<>();
        robotsPosition.add("1 2 N");
        robotsPosition.add("2 2 E");
        Plateau plateau = new Plateau(5,5);
        //when
        Boolean valid = dataValidator.validRobotsPosition(robotsPosition,plateau);
        //then
        assertTrue(valid);
    }
    @Test
    public void invalidRobotsPositionTest() {
        //given
        ArrayList<String> robotsPosition = new ArrayList<>();
        robotsPosition.add("1  N");
        robotsPosition.add("H 2 E");
        Plateau plateau = new Plateau(5,5);
        //when
        Boolean valid = dataValidator.validRobotsPosition(robotsPosition,plateau);
        //then
        assertFalse(valid);
    }
    @Test
    public void validRobotsInstructionsTest() {
        //given
        ArrayList<String> robotsInstructions = new ArrayList<>();
        robotsInstructions.add("MLMLRLM");
        robotsInstructions.add("RLRLM");
        //when
        Boolean valid = dataValidator.validRobotsInstructions(robotsInstructions);
        //then
        assertTrue(valid);
    }
    @Test
    public void invalidRobotsInstructionsTest() {
        //given
        ArrayList<String> robotsInstructions = new ArrayList<>();
        robotsInstructions.add("MLMLKRLM");
        robotsInstructions.add("");
        //when
        Boolean valid = dataValidator.validRobotsInstructions(robotsInstructions);
        //then
        assertFalse(valid);
    }
    @After
    public void tearDown() {
        dataValidator = null;
    }
}
