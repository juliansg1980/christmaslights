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
        TestPanel panel = new TestPanel();

        panel.turnOn(xCoordinate, yCoordinate);

        assertTrue(panel.getLights()[xCoordinate][yCoordinate]);
    }

    @Test
    public void turn_off_a_light() {
        panel.getLights()[0][0] = true;

        panel.turnOff();

        assertFalse(panel.getLights()[0][0]);
    }

    private class TestPanel extends Panel {
        public boolean[][] getLights() {
            return super.lights;
        }
    }
}
