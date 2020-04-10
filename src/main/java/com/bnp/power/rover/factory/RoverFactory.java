package com.bnp.power.rover.factory;

import com.bnp.power.rover.exception.FactoryException;
import com.bnp.power.rover.model.*;

public class RoverFactory implements RobotFactory {
    public Robot createRobot(String type, Position position, Direction direction){
        if (type == null) {
            throw new FactoryException("rover type not specified");
        }
        if (type.equalsIgnoreCase("rover")) {
            return new Rover(position, direction);
        }
        throw new FactoryException("rover type unknown");
    }
}