package com.bnp.power.rover;

import com.bnp.power.rover.controller.RobotController;
import com.bnp.power.rover.data.reader.RoverFileReader;
import com.bnp.power.rover.model.Robot;
import com.bnp.power.rover.view.RobotView;

import java.io.File;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            String fileName = args[0];
            String filePath = System.getProperty("user.dir") + File.separator + fileName;
            RoverFileReader fileReader = new RoverFileReader(filePath);
            List<Robot> robots = fileReader.getRobots();
            List<String> instructions = fileReader.getInstructions();
            RobotController robotController = new RobotController(robots, instructions);
            RobotView view = robotController.runRobots();
            view.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
