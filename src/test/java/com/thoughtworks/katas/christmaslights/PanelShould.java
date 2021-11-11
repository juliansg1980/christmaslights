package com.thoughtworks.katas.christmaslights;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PanelShould {
    @Test
    public void turn_on_a_light() {
        TestPanel panel = new TestPanel();

        panel.turnOn();

        assertTrue(panel.getLights()[0][0]);
    }

    private class TestPanel extends Panel {
        public boolean[][] getLights() {
            return super.lights;
        }
    }
}
