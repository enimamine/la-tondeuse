package com.tondeuse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static com.tondeuse.commons.Constants.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LectureTest {


    //local path
    private static final String PATH_FILE = "./src/main/resources/tondeuse.txt";

    private List<Tondeuse> tendeuses;

    @Before
    public void initialiser() {
        Lecture fichier = new Lecture(PATH_FILE);
        tendeuses = fichier.lire();
    }

    @Test
    public void nombreDeTondeusesTest() {

        assertEquals(2, tendeuses.size());
    }

    @Test
    public void lectureTondeuseTest() {

        assertEquals(1, tendeuses.get(0).getX());
        assertEquals(2, tendeuses.get(0).getY());
        assertEquals(NORD, tendeuses.get(0).getOrientation());
        assertEquals("GAGAGAGAA", tendeuses.get(0).getMouvementsSequance());
    }

    @Test
    public void lecturePelouseTest() {

        assertEquals(5, tendeuses.get(0).getPelouse().getLongueurPelouse());
        assertEquals(5, tendeuses.get(0).getPelouse().getHauteurPelouse());
    }

}
