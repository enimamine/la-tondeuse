package com.tondeuse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TondeuseTest {

    Tondeuse tondeuse = new Tondeuse(0, 0, "N", "GAGAGAGAA");

    @Test
    public void tournerADroiteTest() {
        tondeuse.tournerADroite();
            assertEquals("", "");

    }


}
