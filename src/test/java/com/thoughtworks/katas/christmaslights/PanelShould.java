package com.thoughtworks.katas.christmaslights;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertTrue;

public class PanelShould {
    @ParameterizedTest
    @CsvSource({"0,0", "999,0", "0, 999"})
    public void turn_on_a_light(int xCoordinate, int yCoordinate) {
        TestPanel panel = new TestPanel();

        panel.turnOn(xCoordinate, yCoordinate);

        assertTrue(panel.getLights()[xCoordinate][yCoordinate]);
    }

    private class TestPanel extends Panel {
        public boolean[][] getLights() {
            return super.lights;
        }
    }
}
