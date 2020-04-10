package com.bnp.power.rover.data.validator;

import com.bnp.power.rover.model.Plateau;
import com.bnp.power.rover.model.Position;

public class RoverDataValidator {

    public static boolean validOrientation(String orientation) {
        switch (orientation) {
            case "N":
            case "S":
            case "E":
            case "W":
                return true;
            default:
                return false;
        }
    }
    public static boolean validPosition(Position position, Plateau plateau) {
        return position.getX() >= 0 && position.getY() >= 0
                && position.getX() <= plateau.getWidth()
                && position.getY() <= plateau.getLength();
    }

}
