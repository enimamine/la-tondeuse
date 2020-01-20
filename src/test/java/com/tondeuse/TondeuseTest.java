package com.tondeuse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.tondeuse.commons.Constants.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TondeuseTest {

    Tondeuse tondeuse;
    private static final String SEQUANCE_TEST = "AADAADADDA";
    Pelouse pelouse = new Pelouse(5,5);

    @Test
    public void tournerADroiteInPlaceTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST, pelouse);
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
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST, pelouse);
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
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST, pelouse);
        tondeuse.avancer();
        assertEquals(3, tondeuse.getX());
        assertEquals(4, tondeuse.getY());
    }

    @Test
    public void avancerXTest() {
        tondeuse = new Tondeuse(3, 3, EST, SEQUANCE_TEST, pelouse);
        tondeuse.avancer();
        assertEquals(4, tondeuse.getX());
        assertEquals(3, tondeuse.getY());
    }

    @Test
    public void avancerTournerAGaucheTest() {
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST, pelouse);
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
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST, pelouse);
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
        tondeuse = new Tondeuse(3, 3, NORD, SEQUANCE_TEST, pelouse);
      //  Tondeuse.longueurPelouse = 5;
       // Tondeuse.hauteurPelouse = 5;
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
        tondeuse = new Tondeuse(3, 3, SUD, SEQUANCE_TEST, pelouse);
      //  Tondeuse.longueurPelouse = 5;
      //  Tondeuse.hauteurPelouse = 5;
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
        tondeuse = new Tondeuse(3, 3, EST, SEQUANCE_TEST, pelouse);
    //    Tondeuse.longueurPelouse = 5;
    //    Tondeuse.hauteurPelouse = 5;
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
        tondeuse = new Tondeuse(3, 3, OUEST, SEQUANCE_TEST, pelouse);
    //    Tondeuse.longueurPelouse = 5;
    //    Tondeuse.hauteurPelouse = 5;
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
