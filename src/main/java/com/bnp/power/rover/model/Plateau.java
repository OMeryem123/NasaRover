package com.bnp.power.rover.model;

public final class Plateau {
    private final int width;
    private final int length;

    public Plateau(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
