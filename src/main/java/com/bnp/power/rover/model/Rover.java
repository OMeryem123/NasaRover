package com.bnp.power.rover.model;

public class Rover extends Robot {


    public Rover(Position position, Direction direction) {
        super(position, direction);
    }

    public Rover() {
    }

    public void turnLeft() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.NORTH;
                break;
        }
    }

    public void turnRight() {
        switch (this.direction) {
            case NORTH:
                this.direction = Direction.EAST;
                break;
            case WEST:
                this.direction = Direction.NORTH;
                break;
            case SOUTH:
                this.direction = Direction.WEST;
                break;
            case EAST:
                this.direction = Direction.SOUTH;
                break;
        }
    }

    private void moveUp() {
        this.position.incrementY();
    }

    private void moveDown() {
        this.position.decrementY();
    }

    private void moveLeft() {
        this.position.decrementX();
    }

    private void moveRight() {
        this.position.incrementX();
    }

    public void move() {
        if (!canMove()) {
            return;
        }
        switch (this.direction) {
            case EAST:
                moveRight();
                break;
            case WEST:
                moveLeft();
                break;
            case NORTH:
                moveUp();
                break;
            case SOUTH:
                moveDown();
                break;
        }
    }

    private boolean canMove() {
        if (this.position.getX() == this.plateau.getLength() && this.direction == Direction.EAST) {
            return false;
        }
        if (this.position.getY() == this.plateau.getWidth() && this.direction == Direction.NORTH) {
            return false;
        }
        if (this.position.getX() == 0 && this.direction == Direction.WEST) {
            return false;
        }
        if (this.position.getY() == 0 && this.direction == Direction.SOUTH) {
            return false;
        }
        return true;
    }
}
