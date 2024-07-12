package org.talan.tennistestmaven.model.rest;

public class ScoreJoueur {
    private int setGagnes;
    private int jeuxGagnes;
    private int pointsGagnes;
    private String advantageOrEquality; // Nouveau champ pour avantage ou égalité

    public int getSetGagnes() {
        return setGagnes;
    }

    public void setSetGagnes(int setGagnes) {
        this.setGagnes = setGagnes;
    }

    public int getJeuxGagnes() {
        return jeuxGagnes;
    }

    public void setJeuxGagnes(int jeuxGagnes) {
        this.jeuxGagnes = jeuxGagnes;
    }

    public int getPointsGagnes() {
        return pointsGagnes;
    }

    public void setPointsGagnes(int pointsGagnes) {
        this.pointsGagnes = pointsGagnes;
    }

    public String getAdvantageOrEquality() {
        return advantageOrEquality;
    }

    public void setAdvantageOrEquality(String advantageOrEquality) {
        this.advantageOrEquality = advantageOrEquality;
    }



public String getFormattedPointsGagnes() {
    String[] pointJeuEnCours = {"0", "15", "30", "40"};
    if (pointsGagnes < 0 || pointsGagnes > 3) {
        return "40";
    }
    return pointJeuEnCours[pointsGagnes];
}
}