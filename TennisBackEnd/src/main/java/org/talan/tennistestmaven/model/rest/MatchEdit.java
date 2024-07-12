package org.talan.tennistestmaven.model.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.talan.tennistestmaven.model.data.Arbitre;
import org.talan.tennistestmaven.model.data.Joueur;

import java.time.LocalDateTime;

public class MatchEdit {
    private Joueur player1;
    private Joueur player2;
    private Arbitre referee;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateBegin;

    public LocalDateTime getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDateTime dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Joueur getPlayer1() {
        return player1;
    }

    public void setPlayer1(Joueur player1) {
        this.player1 = player1;
    }

    public Joueur getPlayer2() {
        return player2;
    }

    public void setPlayer2(Joueur player2) {
        this.player2 = player2;
    }

    public Arbitre getReferee() {
        return referee;
    }

    public void setReferee(Arbitre referee) {
        this.referee = referee;
    }


}