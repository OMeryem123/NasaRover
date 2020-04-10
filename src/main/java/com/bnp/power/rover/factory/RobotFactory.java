package com.bnp.power.rover.factory;

import com.bnp.power.rover.model.Direction;
import com.bnp.power.rover.model.Position;
import com.bnp.power.rover.model.Robot;

public interface RobotFactory {
    Robot createRobot(String type, Position position, Direction direction);
}
