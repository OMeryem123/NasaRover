package com.bnp.power.rover.data.validator;

import com.bnp.power.rover.model.Plateau;
import com.bnp.power.rover.model.Position;

import java.util.List;

public class RoverFileValidator implements DataValidator {

    private boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean validPlateauDimension(String line) {
        String[] dimension = line.split(" ");
        return dimension.length == 2 && isDigit(dimension[0]) && isDigit(dimension[1]);
    }

    private boolean validRobotPosition(String line, Plateau plateau) {
        String[] pos = line.split(" ");
        if(pos.length == 3  && isDigit(pos[0]) && isDigit(pos[1] )) {
            Position position = new Position(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
            return RoverDataValidator.validPosition(position, plateau) && RoverDataValidator.validOrientation(pos[2]);
        }
        return false;
    }

    @Override
    public boolean validRobotsPosition(List<String> lines, Plateau plateau) {
        for(String line: lines) {
            if(!validRobotPosition(line, plateau)) {
                return false;
            }
        }
        return true;
    }

    private boolean validInstructions(String line) {
        char[] instr = line.toCharArray();
        for (char instruction : instr) {
            if (!validInstruction(instruction)) {
                return false;
            }
        }
        return true;
    }

    public boolean validRobotsInstructions(List<String> lines) {
        for(String line: lines) {
            if(!validInstructions(line)) {
                return false;
            }
        }
        return true;
    }

    private boolean validInstruction(char instruction) {
        return instruction == 'L' || instruction == 'R' || instruction == 'M';
    }
}