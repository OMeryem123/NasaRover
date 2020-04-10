package com.bnp.power.rover.data.validator;

import com.bnp.power.rover.model.Plateau;

import java.util.List;

public interface DataValidator {
    boolean validRobotsPosition(List<String> lines, Plateau plateau);
    boolean validRobotsInstructions(List<String> lines);
    boolean validPlateauDimension(String line);
}
