package com.bnp.power.rover.model;
public abstract class Robot {
    protected Position position;
    protected Direction direction;
    protected Plateau plateau;

    public Robot() {
    }

    public Robot(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public abstract void move();

    public abstract void turnLeft();

    public abstract void turnRight();

    @Override
    public String toString() {
        return this.position + " " + this.direction.getShortName();
    }

}
