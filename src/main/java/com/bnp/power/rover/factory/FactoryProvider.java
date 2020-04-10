package com.bnp.power.rover.factory;

import com.bnp.power.rover.exception.FactoryException;

public class FactoryProvider {
    private FactoryProvider() {
    }
    public static RobotFactory getRobotFactory(String factory){
       if(factory == null){
            throw new FactoryException("Factory not specified");
       }
       if(factory.equalsIgnoreCase("RoverFactory")){
           return new RoverFactory();
       }
       throw new FactoryException("Factory "+ factory +" not found");
    }
}
