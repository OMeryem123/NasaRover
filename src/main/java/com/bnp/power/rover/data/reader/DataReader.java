package com.bnp.power.rover.data.reader;

import com.bnp.power.rover.model.Robot;

import java.io.IOException;
import java.util.List;

public interface DataReader{
    List<Robot> getRobots() throws IOException;
    List<String> getInstructions() throws IOException;
}
