package org.talan.tennistestmaven.service;

import org.springframework.stereotype.Service;
import org.talan.tennistestmaven.model.data.Match;
import org.talan.tennistestmaven.model.rest.MatchCreate;
import org.talan.tennistestmaven.model.rest.Score;
import org.talan.tennistestmaven.model.rest.ScoreJoueur;

@Service
public class ScoreService {

    private MatchCreate currentMatch;

    public ScoreService() {
        currentMatch = new MatchCreate();
        currentMatch.setId(1L);
        currentMatch.setPlayer1Id(1L);
        currentMatch.setPlayer2Id(2L);
        currentMatch.setRefereeId(1L);

        Score score = new Score();
        ScoreJoueur scoreJoueur1 = new ScoreJoueur();
        ScoreJoueur scoreJoueur2 = new ScoreJoueur();

        score.setScoreJoueur1(scoreJoueur1);
        score.setScoreJoueur2(scoreJoueur2);

        currentMatch.setScore(score);
    }

     public Score updateScore(String player) {
        if ("player1".equals(player)) {
            addPointToPlayer1();
        } else if ("player2".equals(player)) {
            addPointToPlayer2();
        }
        return currentMatch.getScore();
    }

    public Score getCurrentScore() {
        return currentMatch.getScore();
    }

    private void addPointToPlayer1() {
        ScoreJoueur scoreJoueur1 = currentMatch.getScore().getScoreJoueur1();
        ScoreJoueur scoreJoueur2 = currentMatch.getScore().getScoreJoueur2();

        int sumPointsPlayer1 = scoreJoueur1.getPointsGagnes();
        int sumPointsPlayer2 = scoreJoueur2.getPointsGagnes();

        if (sumPointsPlayer1 < 3) {
            scoreJoueur1.setPointsGagnes(sumPointsPlayer1 + 1);
        } else if (sumPointsPlayer1 == 3) {
            if (sumPointsPlayer2 == 3) {
                scoreJoueur1.setPointsGagnes(4); // Joueur 1 prend l'avantage
            } else {
                scoreJoueur1.setJeuxGagnes(scoreJoueur1.getJeuxGagnes() + 1);
                checkAndUpdateSet(scoreJoueur1, scoreJoueur2);
                resetPoints();
            }
        } else if (sumPointsPlayer1 >= 4) {
            if (sumPointsPlayer1 - sumPointsPlayer2 >= 1) {
                if (sumPointsPlayer1 - sumPointsPlayer2 >= 2) {
                    scoreJoueur1.setJeuxGagnes(scoreJoueur1.getJeuxGagnes() + 1);
                    checkAndUpdateSet(scoreJoueur1, scoreJoueur2);
                    resetPoints();
                } else {
                    // Joueur 1 a l'avantage
                    scoreJoueur1.setPointsGagnes(sumPointsPlayer1 + 1);
                }
            } else if (sumPointsPlayer2 - sumPointsPlayer1 >= 1) {
                if (sumPointsPlayer2 - sumPointsPlayer1 >= 2) {
                    scoreJoueur2.setJeuxGagnes(scoreJoueur2.getJeuxGagnes() + 1);
                    checkAndUpdateSet(scoreJoueur1, scoreJoueur2);
                    resetPoints();
                } else {
                    // Joueur 2 a l'avantage
                    scoreJoueur2.setPointsGagnes(sumPointsPlayer2 + 1);
                }
            } else {
                // Retour à l'égalité
                scoreJoueur1.setPointsGagnes(3);
                scoreJoueur2.setPointsGagnes(3);
            }
        }

        updateAdvantageOrEquality(scoreJoueur1, scoreJoueur2);
    }

    private void addPointToPlayer2() {
        ScoreJoueur scoreJoueur1 = currentMatch.getScore().getScoreJoueur1();
        ScoreJoueur scoreJoueur2 = currentMatch.getScore().getScoreJoueur2();

        int sumPointsPlayer1 = scoreJoueur1.getPointsGagnes();
        int sumPointsPlayer2 = scoreJoueur2.getPointsGagnes();

        if (sumPointsPlayer2 < 3) {
            scoreJoueur2.setPointsGagnes(sumPointsPlayer2 + 1);
        } else if (sumPointsPlayer2 == 3) {
            if (sumPointsPlayer1 == 3) {
                scoreJoueur2.setPointsGagnes(4); // Avantage
            } else {
                scoreJoueur2.setJeuxGagnes(scoreJoueur2.getJeuxGagnes() + 1);
                checkAndUpdateSet(scoreJoueur1, scoreJoueur2);
                resetPoints();
            }
        } else if (sumPointsPlayer2 >= 4) {
            if (sumPointsPlayer2 - sumPointsPlayer1 >= 1) {
                if (sumPointsPlayer2 - sumPointsPlayer1 >= 2) {
                    scoreJoueur2.setJeuxGagnes(scoreJoueur2.getJeuxGagnes() + 1);
                    checkAndUpdateSet(scoreJoueur1, scoreJoueur2);
                    resetPoints();
                } else {
                    // Joueur 2 a l'avantage
                    scoreJoueur2.setPointsGagnes(sumPointsPlayer2 + 1);
                }
            } else if (sumPointsPlayer1 - sumPointsPlayer2 >= 1) {
                if (sumPointsPlayer1 - sumPointsPlayer2 >= 2) {
                    scoreJoueur1.setJeuxGagnes(scoreJoueur1.getJeuxGagnes() + 1);
                    checkAndUpdateSet(scoreJoueur1, scoreJoueur2);
                    resetPoints();
                } else {
                    // Joueur 1 a l'avantage
                    scoreJoueur1.setPointsGagnes(sumPointsPlayer1 + 1);
                }
            } else {
                // Retour à l'égalité
                scoreJoueur1.setPointsGagnes(3);
                scoreJoueur2.setPointsGagnes(3);
            }
        }

        updateAdvantageOrEquality(scoreJoueur1, scoreJoueur2);
    }

    private void resetPoints() {
        ScoreJoueur scoreJoueur1 = currentMatch.getScore().getScoreJoueur1();
        ScoreJoueur scoreJoueur2 = currentMatch.getScore().getScoreJoueur2();
        scoreJoueur1.setPointsGagnes(0);
        scoreJoueur2.setPointsGagnes(0);
    }

    private void checkAndUpdateSet(ScoreJoueur scoreJoueur1, ScoreJoueur scoreJoueur2) {
        if (scoreJoueur1.getJeuxGagnes() >= 6 && scoreJoueur1.getJeuxGagnes() > scoreJoueur2.getJeuxGagnes() + 1) {
            scoreJoueur1.setSetGagnes(scoreJoueur1.getSetGagnes() + 1);
            resetGames();
        } else if (scoreJoueur2.getJeuxGagnes() >= 6 && scoreJoueur2.getJeuxGagnes() > scoreJoueur1.getJeuxGagnes() + 1) {
            scoreJoueur2.setSetGagnes(scoreJoueur2.getSetGagnes() + 1);
            resetGames();
        }
    }

    private void resetGames() {
        ScoreJoueur scoreJoueur1 = currentMatch.getScore().getScoreJoueur1();
        ScoreJoueur scoreJoueur2 = currentMatch.getScore().getScoreJoueur2();
        scoreJoueur1.setJeuxGagnes(0);
        scoreJoueur2.setJeuxGagnes(0);
    }

    private void updateAdvantageOrEquality(ScoreJoueur scoreJoueur1, ScoreJoueur scoreJoueur2) {
        int sumPointsPlayer1 = scoreJoueur1.getPointsGagnes();
        int sumPointsPlayer2 = scoreJoueur2.getPointsGagnes();

        if (sumPointsPlayer1 == 3 && sumPointsPlayer2 == 3) {
            // Egalité
            scoreJoueur1.setAdvantageOrEquality("E");
            scoreJoueur2.setAdvantageOrEquality("E");
        } else if (sumPointsPlayer1 == 4) {
            // Avantage joueur 1
            scoreJoueur1.setAdvantageOrEquality("A");
            scoreJoueur2.setAdvantageOrEquality("");
        } else if (sumPointsPlayer2 == 4) {
            // Avantage joueur 2
            scoreJoueur1.setAdvantageOrEquality("");
            scoreJoueur2.setAdvantageOrEquality("A");
        } else if (sumPointsPlayer1 == sumPointsPlayer2 && sumPointsPlayer1 >= 4) {
            // Egalité
            scoreJoueur1.setAdvantageOrEquality("E");
            scoreJoueur2.setAdvantageOrEquality("E");
        } else if (sumPointsPlayer1 > sumPointsPlayer2 && sumPointsPlayer1 >= 4) {
            // Avantage joueur 1
            scoreJoueur1.setAdvantageOrEquality("A");
            scoreJoueur2.setAdvantageOrEquality("");
        } else if (sumPointsPlayer2 > sumPointsPlayer1 && sumPointsPlayer2 >= 4) {
            // Avantage joueur 2
            scoreJoueur1.setAdvantageOrEquality("");
            scoreJoueur2.setAdvantageOrEquality("A");
        } else {
            // Réinitialisation des indications d'avantage ou d'égalité
            scoreJoueur1.setAdvantageOrEquality("");
            scoreJoueur2.setAdvantageOrEquality("");
        }
    }
}
