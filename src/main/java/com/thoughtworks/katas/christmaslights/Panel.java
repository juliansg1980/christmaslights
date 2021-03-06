package com.thoughtworks.katas.christmaslights;

public class Panel {
    public static final int xLength = 1000;
    public static final int yLength = 1000;
    protected boolean lights[][];

    public Panel() {
        lights = new boolean[xLength][yLength];
    }

    public void turnOn(Coordinate lightToTurnOn) {
        lights[lightToTurnOn.getX()][lightToTurnOn.getY()] = true;
    }

    public void turnOff(Coordinate coordinate) {
        lights[coordinate.getX()][coordinate.getY()] = false;
    }

    public void toggle(Coordinate coordinate) {
        if (isLightOn(coordinate))
            turnOff(coordinate);
        else
            turnOn(coordinate);
    }

    private boolean isLightOn(Coordinate coordinate) {
        return lights[coordinate.getX()][coordinate.getY()] == true;
    }

    public void turnOn(Coordinate startCoordinate, Coordinate endCoordinate) {
        for (int xPosition = startCoordinate.getX(); xPosition <= endCoordinate.getX(); xPosition++) {
            for (int yPosition = startCoordinate.getY(); yPosition <= endCoordinate.getY(); yPosition++) {
                turnOn(new Coordinate(xPosition, yPosition));
            }
        }
    }

    public void turnOff(Coordinate startCoordinate, Coordinate endCoordinate) {
        for (int xPosition = startCoordinate.getX(); xPosition <= endCoordinate.getX(); xPosition++) {
            for (int yPosition = startCoordinate.getY(); yPosition <= endCoordinate.getY(); yPosition++) {
                turnOff(new Coordinate(xPosition, yPosition));
            }
        }
    }
}
