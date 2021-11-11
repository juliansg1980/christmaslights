package com.thoughtworks.katas.christmaslights;

public class Panel {
    public static final int xLength = 1;
    public static final int yLength = 1;
    protected boolean lights[][];

    public Panel() {
        lights = new boolean[xLength][yLength];
    }

    public void turnOn() {
        lights[0][0] = true;
    }
}
