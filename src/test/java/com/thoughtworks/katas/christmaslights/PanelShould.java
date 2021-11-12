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
        Coordinate givenACoordinate = new Coordinate(xCoordinate, yCoordinate);

        panel.turnOn(givenACoordinate);

        assertTrue(getLightStateFor(givenACoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,999", "999,0", "999,999"})
    public void turn_off_a_light(int xCoordinate, int yCoordinate) {
        Coordinate givenACoordinate = new Coordinate(xCoordinate, yCoordinate);
        TurnOnLightForTest(givenACoordinate);

        panel.turnOff(givenACoordinate);

        assertFalse(getLightStateFor(givenACoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,999", "999,0", "999,999"})
    public void toggle_a_light_when_the_light_is_off(int xCoordinate, int yCoordinate) {
        Coordinate givenACoordinate = new Coordinate(xCoordinate, yCoordinate);
        TurnOffLightForTest(givenACoordinate);

        panel.toggle(givenACoordinate);

        assertTrue(getLightStateFor(givenACoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,999", "999,0", "999,999"})
    public void toggle_a_light_when_the_light_is_on(int xCoordinate, int yCoordinate) {
        Coordinate givenACoordinate = new Coordinate(xCoordinate, yCoordinate);
        TurnOnLightForTest(givenACoordinate);

        panel.toggle(givenACoordinate);

        assertFalse(getLightStateFor(givenACoordinate));
    }

    @ParameterizedTest
    @CsvSource({"0,0, 1, 1", "998, 998, 999, 999","0,0,999,999"})
    public void turn_a_range_of_lights_on(int startX, int startY, int endX, int endY){
        Coordinate givenAStartCoordinate = new Coordinate(startX, startY);
        Coordinate givenAnEndCoordinate = new Coordinate(endX, endY);

        panel.turnOn(givenAStartCoordinate, givenAnEndCoordinate);

        for (int xPosition = startX; xPosition <= endX ; xPosition++) {
            for (int yPosition = startY; yPosition <= endY ; yPosition++) {
                assertTrue(getLightStateFor(new Coordinate(xPosition, yPosition)));
            }
        }
    }

    @Test
    public void turn_a_range_of_lights_off(){
        Coordinate givenAStartCoordinate = new Coordinate(0, 0);
        Coordinate givenAnEndCoordinate = new Coordinate(1, 1);
        TurnOnLightForTest(new Coordinate(0, 0));
        TurnOnLightForTest(new Coordinate(0, 1));
        TurnOnLightForTest(new Coordinate(1, 0));
        TurnOnLightForTest(new Coordinate(1, 1));

        panel.turnOff(givenAStartCoordinate, givenAnEndCoordinate);

        assertFalse(getLightStateFor(new Coordinate(0, 0)));
        assertFalse(getLightStateFor(new Coordinate(0, 1)));
        assertFalse(getLightStateFor(new Coordinate(1, 0)));
        assertFalse(getLightStateFor(new Coordinate(1, 1)));
    }

    @Test
    public void turn_another_range_of_lights_off(){
        Coordinate givenAStartCoordinate = new Coordinate(998, 998);
        Coordinate givenAnEndCoordinate = new Coordinate(999, 999);
        TurnOnLightForTest(new Coordinate(998, 998));
        TurnOnLightForTest(new Coordinate(998, 999));
        TurnOnLightForTest(new Coordinate(999, 998));
        TurnOnLightForTest(new Coordinate(999, 999));

        panel.turnOff(givenAStartCoordinate, givenAnEndCoordinate);

        assertFalse(getLightStateFor(new Coordinate(998, 998)));
        assertFalse(getLightStateFor(new Coordinate(998, 999)));
        assertFalse(getLightStateFor(new Coordinate(999, 998)));
        assertFalse(getLightStateFor(new Coordinate(999, 999)));
    }


    private void TurnOffLightForTest(Coordinate coordinate) {
        panel.getLights()[coordinate.getX()][coordinate.getY()] = false;
    }

    private boolean getLightStateFor(Coordinate coordinate) {
        return panel.getLights()[coordinate.getX()][coordinate.getY()];
    }

    private void TurnOnLightForTest(Coordinate coordinate) {
        panel.getLights()[coordinate.getX()][coordinate.getY()] = true;
    }

    private class TestPanel extends Panel {
        public boolean[][] getLights() {
            return super.lights;
        }
    }
}
