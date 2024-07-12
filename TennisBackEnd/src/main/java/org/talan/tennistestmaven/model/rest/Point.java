package org.talan.tennistestmaven.model.rest;

public class Point {
    private int id;
    private boolean gagneParJoueur1;

    public boolean isGagneParJoueur1() {
        return gagneParJoueur1;
    }

    public void setGagneParJoueur1(boolean gagneParJoueur1) {
        this.gagneParJoueur1 = gagneParJoueur1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
