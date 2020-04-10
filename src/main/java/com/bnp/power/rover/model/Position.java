package com.bnp.power.rover.model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementX() {
        this.x++;
    }

    public void incrementY() {
        this.y++;
    }

    public void decrementX() {
        this.x--;
    }

    public void decrementY() {
        this.y--;
    }

    @Override
    public String toString() {
        return "" + x + " " + y;
    }
}
