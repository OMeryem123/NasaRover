package com.bnp.power.rover.model;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");
    private String shortName;

    public String getShortName() {
        return shortName;
    }

    Direction(String shortName) {
        this.shortName = shortName;
    }
}
