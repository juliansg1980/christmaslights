package com.thoughtworks.katas.christmaslights;

public class Panel {
    protected boolean lights[][];

    public Panel() {
        lights = new boolean[1][1];
    }

    public void turnOn() {
        lights[0][0] = true;
    }
}
