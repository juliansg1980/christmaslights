package com.thoughtworks.katas.christmaslights;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PanelShould {

    private TestPanel panel;

    @BeforeEach
    public void SetUp() {
        panel = new TestPanel();
    }

    @ParameterizedTest
    @CsvSource({"0,0", "999,0", "0, 999", "999, 999"})
    public void turn_on_a_light(int xCoordinate, int yCoordinate) {
        panel.turnOn(xCoordinate, yCoordinate);

        assertTrue(getLightStateFor(xCoordinate, yCoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,999", "999,0", "999,999"})
    public void turn_off_a_light(int xCoordinate, int yCoordinate) {
        TurnOnLightForTest(xCoordinate, yCoordinate);

        panel.turnOff(xCoordinate, yCoordinate);

        assertFalse(getLightStateFor(xCoordinate, yCoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,999", "999,0", "999,999"})
    public void toggle_a_light_when_the_light_is_off(int xCoordinate, int yCoordinate) {
        TurnOffLightForTest(xCoordinate,yCoordinate);

        panel.toggle(xCoordinate,yCoordinate);

        assertTrue(getLightStateFor(xCoordinate,yCoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0,0"})
    public void toggle_a_light_when_the_light_is_on(int xCoordinate, int yCoordinate) {
        TurnOnLightForTest(xCoordinate, yCoordinate);

        panel.toggle(xCoordinate, yCoordinate);

        assertFalse(getLightStateFor(xCoordinate, yCoordinate));
    }

    private void TurnOffLightForTest(int xCoordinate, int yCoordinate) {
        panel.getLights()[xCoordinate][yCoordinate] = false;
    }

    private boolean getLightStateFor(int xCoordinate, int yCoordinate) {
        return panel.getLights()[xCoordinate][yCoordinate];
    }

    private void TurnOnLightForTest(int xCoordinate, int yCoordinate) {
        panel.getLights()[xCoordinate][yCoordinate] = true;
    }

    private class TestPanel extends Panel {
        public boolean[][] getLights() {
            return super.lights;
        }
    }
}
