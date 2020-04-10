package com.bnp.power.rover.data.reader;


import com.bnp.power.rover.data.validator.DataValidator;
import com.bnp.power.rover.data.validator.RoverFileValidator;
import com.bnp.power.rover.exception.FileValidationException;
import com.bnp.power.rover.factory.RobotFactory;
import com.bnp.power.rover.model.*;
import com.bnp.power.rover.factory.FactoryProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RoverFileReader implements DataReader {
    private Path path;
    private DataValidator dataValidator;

    private Plateau getPlateau() throws IOException, FileValidationException {
        String line = getLines().get(0);
        if(!dataValidator.validPlateauDimension(line)) {
            throw new FileValidationException("valid plan");
        }
        String[] dimension = line.split(" ");
        int x = Integer.parseInt(dimension[0]);
        int y = Integer.parseInt(dimension[1]);
        return new Plateau(x, y);
    }

    private Direction getOrientation(String c) {
        switch (c) {
            case "N":
                return Direction.NORTH;
            case "S":
                return Direction.SOUTH;
            case "E":
                return Direction.EAST;
            case "W":
                return Direction.WEST;
        }
        return null;
    }

    public List<String> getInstructions() throws IOException,FileValidationException {
        List<String> lines = getLines();
        List<String> result = IntStream.range(2, lines.size())
                .filter(lineNumber -> lineNumber % 2 == 0)
                .mapToObj(lines::get)
                .collect(Collectors.toList());
        if(!dataValidator.validRobotsInstructions(result)) {
            throw new FileValidationException("invalid instructions");
        }
        return result;

    }

    private List<String> getRobotLines() throws IOException {
        List<String> lines = getLines();
        return IntStream.range(1, lines.size() - 1)
                .filter(lineNumber -> lineNumber % 2 != 0)
                .mapToObj(lines::get)
                .collect(Collectors.toList());
    }

    private List<String> getLines() throws IOException {
        try (Stream<String> lines = Files.lines(this.path)) {
            return lines.collect(Collectors.toList());
        }
    }

    private Robot getRobot(String positionLine) {
        String[] position = positionLine.split(" ");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        Direction direction = getOrientation(position[2]);
        RobotFactory robotFactory = FactoryProvider.getRobotFactory("roverfactory");
        return robotFactory.createRobot("rover", new Position(x, y), direction);
    }

    public List<Robot> getRobots() throws IOException , FileValidationException{
        List<String> robotLines = getRobotLines();
        Plateau plateau = getPlateau();
        if(!dataValidator.validRobotsPosition(robotLines, plateau)) {
            throw new FileValidationException("invalid robots position");
        }
        List<Robot> robots = robotLines.stream()
                .map(this::getRobot)
                .collect(Collectors.toList());
        robots.forEach(robot -> robot.setPlateau(plateau));
        return robots;
    }

    public RoverFileReader(String path) {
        this.path = Paths.get(path);
        this.dataValidator = new RoverFileValidator();
    }
}
