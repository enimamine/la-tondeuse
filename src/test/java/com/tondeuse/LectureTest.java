package com.tondeuse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static com.tondeuse.commons.Constants.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LectureTest {


    private static final String P£ATH_FILE = "/Users/amiaidel1/Documents/projets/tondeuse1/latondeuse-v2/src/main/resources/tondeuse.txt";

    @Test
    public void nombreDeTondeusesTest() {

        Lecture fichier = new Lecture(P£ATH_FILE);
        List<Tondeuse> tendeuses = fichier.lire();

        assertEquals(2, tendeuses.size());
    }

    @Test
    public void lectureTondeuseTest() {

        Lecture fichier1 = new Lecture(P£ATH_FILE);
        List<Tondeuse> tendeuses = fichier1.lire();

        assertEquals(1, tendeuses.get(0).getX());
        assertEquals(2, tendeuses.get(0).getY());
        assertEquals(NORD, tendeuses.get(0).getOrientation());
        assertEquals("GAGAGAGAA", tendeuses.get(0).getMouvementsSequance());

    }


}
