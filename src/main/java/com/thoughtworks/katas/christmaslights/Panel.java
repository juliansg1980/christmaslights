package com.thoughtworks.katas.christmaslights;

public class Panel {
    public static final int xLength = 1000;
    public static final int yLength = 1000;
    protected boolean lights[][];

    public Panel() {
        lights = new boolean[xLength][yLength];
    }

    public void turnOn(int xCoordinate, int yCoordinate) {
        lights[xCoordinate][yCoordinate] = true;
    }

    public void turnOff(int xCoordinate, int yCoordinate) {
        lights[xCoordinate][yCoordinate] = false;
    }

    public void toggle(int xCoordinate, int yCoordinate) {
        if (isLightOn(xCoordinate, yCoordinate))
            turnOff(xCoordinate, yCoordinate);
        else
            turnOn(xCoordinate, yCoordinate);
    }

    private boolean isLightOn(int xCoordinate, int yCoordinate) {
        return lights[xCoordinate][yCoordinate] == true;
    }

    public void turnOn(Coordinate lightToTurnOn) {
        lights[lightToTurnOn.getX()][lightToTurnOn.getY()] = true;
    }
}
