package com.tondeuse;

import static com.tondeuse.commons.Constants.*;

public class Tondeuse {

    // position de la tondeuse
    private int x;
    private int y;
    private String orientation;
    private String mouvementsSequance;
    private Pelouse pelouse ;

    private char mouvement;

    public Tondeuse(int x, int y, String orientation, String mouvementsSequance, Pelouse pelouse) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.mouvementsSequance = mouvementsSequance;
        this.pelouse=pelouse;
    }

    public void deplacer() {

        for (int i = 0; i <= mouvementsSequance.length() - 1; i++) {
            mouvement = mouvementsSequance.charAt(i);

            switch (mouvement) {
                case 'G':
                    tournerAGauche();
                    break;
                case 'D':
                    tournerADroite();
                    break;
                case 'A':
                    // verifier si sortie de peulouse
                    if (!isHorsPelouse()) {
                        avancer();
                    }
                    break;
            }

        }
        //communiquer la position de la tondeuse
        System.out.println(x + " " + y + " " + orientation);
    }

    protected boolean isHorsPelouse() {

        return (y >= pelouse.getHauteurPelouse() && orientation.equals(NORD)) ||
                (x >= pelouse.getLongueurPelouse() && orientation.equals(EST)) ||
                (x <= 0 && orientation.equals(OUEST)) ||
                (y <= 0 && orientation.equals(SUD));
    }

    public void tournerADroite() {

        switch (orientation) {
            case NORD:
                orientation = EST;
                break;
            case EST:
                orientation = SUD;
                break;
            case SUD:
                orientation = OUEST;
                break;
            case OUEST:
                orientation = NORD;
                break;
        }
    }

    public void tournerAGauche() {

        switch (orientation) {
            case NORD:
                orientation = OUEST;
                break;
            case OUEST:
                orientation = SUD;
                break;
            case SUD:
                orientation = EST;
                break;
            case EST:
                orientation = NORD;
                break;
        }
    }

    public void avancer() {

        switch (orientation) {
            case NORD:
                y++;
                break;
            case OUEST:
                x--;
                break;
            case SUD:
                y--;
                break;
            case EST:
                x++;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getMouvementsSequance() {
        return mouvementsSequance;
    }

    public Pelouse getPelouse() {
        return pelouse;
    }
}
