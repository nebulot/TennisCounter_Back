package org.talan.tennistestmaven.model.rest;

public class Score {
    private ScoreJoueur scoreJoueur1;
    private ScoreJoueur scoreJoueur2;

    public ScoreJoueur getScoreJoueur1() {
        return scoreJoueur1;
    }

    public void setScoreJoueur1(ScoreJoueur scoreJoueur1) {
        this.scoreJoueur1 = scoreJoueur1;
    }

    public ScoreJoueur getScoreJoueur2() {
        return scoreJoueur2;
    }

    public void setScoreJoueur2(ScoreJoueur scoreJoueur2) {
        this.scoreJoueur2 = scoreJoueur2;
    }
}