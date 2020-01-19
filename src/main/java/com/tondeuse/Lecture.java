package com.tondeuse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Lecture {

    private String fichier;
    private List tendeuses = new ArrayList();

    public Lecture(String fichier) {
        this.fichier = fichier;
    }

    public List lire() {

        // lecture du fichier
        try {
            FileReader fileReader = new FileReader(fichier);
            BufferedReader bufferReader = new BufferedReader(fileReader);

            String ligne;
            String[] splitLigne;
            int count = 0;
            Tondeuse tondeuse;

            while ((ligne = bufferReader.readLine()) != null) {

                splitLigne = ligne.split(" ");

                if (count == 0) {
                    // initialisation de la peulouse
                    Tondeuse.longueurPelouse = Integer.parseInt(splitLigne[0]);
                    Tondeuse.hauteurPelouse = Integer.parseInt(splitLigne[1]);
                    System.out.println("Taille de la pelouse : " + splitLigne[0] + " " + splitLigne[1]);
                } else {
                    // sinon instencier  une nouvelle tondeuse
                    ligne = bufferReader.readLine();
                    tondeuse = new Tondeuse(Integer.parseInt(splitLigne[0]), Integer.parseInt(splitLigne[1]), splitLigne[2], ligne);
                    // verifier que la tondeuse est bien dans la pelouse avant de l'ajouter à notre liste...
                    if (!tondeuse.isHorsPelouse()) {
                        tendeuses.add(tondeuse);
                    }
                }
                count++;
            }

            fileReader.close();

        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Problème lors de la lecture du fichier");
        }

        return tendeuses;
    }

}
