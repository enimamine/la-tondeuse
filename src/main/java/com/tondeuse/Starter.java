package com.tondeuse;

import java.util.List;
import java.util.Scanner;

public class Starter {

    private static List<Tondeuse> tendeuses;

    public static void main(String[] args) {

        try {
            lireFichier();

            for (Tondeuse tendeuse : tendeuses) {
                tendeuse.deplacer();
            }

        } catch (Exception e) {
            System.out.println("Ah! La Tondeuse est en panne  ! ");
        }

    }

    private static void lireFichier() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le chemain vers le ficher des instructions des tondeuses:");
        /*   Exmelples de paths:
         *   /Users/amiaidel1/Documents/projets/tondeuse1/latondeuse-v2/src/main/resources/tondeuse.txt
         *
         */

        String path = scanner.nextLine();
        Lecture fichier = new Lecture(path);
        tendeuses = fichier.lire();
    }

}
