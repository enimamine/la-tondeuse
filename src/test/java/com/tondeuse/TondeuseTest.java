package com.tondeuse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.tondeuse.commons.Constants.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TondeuseTest {

    Tondeuse tondeuse;
    static final String SEQUANCE_TEST = "AADAADADDA";

    @Test
    public void tournerADroiteInPlaceTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST);
        tondeuse.tournerADroite();
        assertEquals(EST, tondeuse.getOrientation());
        tondeuse.tournerADroite();
        assertEquals(SUD, tondeuse.getOrientation());
        tondeuse.tournerADroite();
        assertEquals(OUEST, tondeuse.getOrientation());
        tondeuse.tournerADroite();
        assertEquals(NORD, tondeuse.getOrientation());
        assertEquals(3, tondeuse.getX());
        assertEquals(3, tondeuse.getY());
    }

    @Test
    public void tournerAGaucheInPlaceTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST);
        tondeuse.tournerAGauche();
        assertEquals(OUEST, tondeuse.getOrientation());
        tondeuse.tournerAGauche();
        assertEquals(SUD, tondeuse.getOrientation());
        tondeuse.tournerAGauche();
        assertEquals(EST, tondeuse.getOrientation());
        tondeuse.tournerAGauche();
        assertEquals(NORD, tondeuse.getOrientation());
        assertEquals(3, tondeuse.getX());
        assertEquals(3, tondeuse.getY());

    }

    @Test
    public void avancerYTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST);
        tondeuse.avancer();
        assertEquals(3, tondeuse.getX());
        assertEquals(4, tondeuse.getY());
    }

    @Test
    public void avancerXTest() {
        tondeuse = new Tondeuse(3, 3, EST, SEQUANCE_TEST);
        tondeuse.avancer();
        assertEquals(4, tondeuse.getX());
        assertEquals(3, tondeuse.getY());
    }

    @Test
    public void avancerTournerAGaucheTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST);
        tondeuse.avancer();
        tondeuse.tournerAGauche();
        assertEquals(OUEST, tondeuse.getOrientation());
        tondeuse.tournerAGauche();
        assertEquals(SUD, tondeuse.getOrientation());
        tondeuse.tournerAGauche();
        assertEquals(EST, tondeuse.getOrientation());
        tondeuse.tournerAGauche();
        assertEquals(NORD, tondeuse.getOrientation());
        assertEquals(3, tondeuse.getX());
        assertEquals(4, tondeuse.getY());

    }

    @Test
    public void avancerTournerADroiteTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST);
        tondeuse.avancer();
        tondeuse.tournerADroite();
        assertEquals(EST, tondeuse.getOrientation());
        tondeuse.tournerADroite();
        assertEquals(SUD, tondeuse.getOrientation());
        tondeuse.tournerADroite();
        assertEquals(OUEST, tondeuse.getOrientation());
        tondeuse.tournerADroite();
        assertEquals(NORD, tondeuse.getOrientation());
        assertEquals(3, tondeuse.getX());
        assertEquals(4, tondeuse.getY());
    }

    @Test
    public void isHorsPelouseHautTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST);
        tondeuse.longueurPelouse = 5;
        tondeuse.hauteurPelouse = 5;
        assertEquals(3, tondeuse.getY());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(4, tondeuse.getY());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(5, tondeuse.getY());
        assertEquals(true, tondeuse.isHorsPelouse());
    }

    @Test
    public void isHorsPelouseBasTest() {
        tondeuse = new Tondeuse(3, 3, SUD, SEQUANCE_TEST);
        tondeuse.longueurPelouse = 5;
        tondeuse.hauteurPelouse = 5;
        assertEquals(3, tondeuse.getY());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(2, tondeuse.getY());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(1, tondeuse.getY());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(0, tondeuse.getY());
        assertEquals(true, tondeuse.isHorsPelouse());
    }

    @Test
    public void isHorsPelouseDroiteTest() {
        tondeuse = new Tondeuse(3, 3, EST, SEQUANCE_TEST);
        tondeuse.longueurPelouse = 5;
        tondeuse.hauteurPelouse = 5;
        assertEquals(3, tondeuse.getX());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(4, tondeuse.getX());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(5, tondeuse.getX());
        assertEquals(true, tondeuse.isHorsPelouse());
    }

    @Test
    public void isHorsPelouseGaucheTest() {
        tondeuse = new Tondeuse(3, 3, OUEST, SEQUANCE_TEST);
        tondeuse.longueurPelouse = 5;
        tondeuse.hauteurPelouse = 5;
        assertEquals(3, tondeuse.getX());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(2, tondeuse.getX());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(1, tondeuse.getX());
        assertEquals(false, tondeuse.isHorsPelouse());
        tondeuse.avancer();
        assertEquals(0, tondeuse.getX());
        assertEquals(true, tondeuse.isHorsPelouse());
    }

}
