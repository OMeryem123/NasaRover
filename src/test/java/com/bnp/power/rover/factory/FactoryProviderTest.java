package com.bnp.power.rover.factory;

import com.bnp.power.rover.exception.FactoryException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class FactoryProviderTest {

    @Test(expected = FactoryException.class)
    public void getNullFactoryTest() {
        FactoryProvider.getRobotFactory(null);
    }

    @Test(expected = FactoryException.class)
    public void getUnknowFactoryTest() {
        FactoryProvider.getRobotFactory("azer");
    }

    @Test
    public void getRoverFactoryTest() {
        //when
        RobotFactory robotFactory = FactoryProvider.getRobotFactory("roverFactory");
        //then
        assertTrue(robotFactory instanceof RoverFactory);
    }
}
