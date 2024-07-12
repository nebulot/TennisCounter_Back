package org.talan.tennistestmaven.model.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class MatchCreate {

    private Long id; // Utilisation de Long pour permettre les valeurs nulles
    private Long player1Id;
    private Long player2Id;
    private Long refereeId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateBegin;
    private Score score;

    public Long getId() { // Utilisation de Long pour permettre les valeurs nulles
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(Long player1Id) {
        this.player1Id = player1Id;
    }

    public Long getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Long player2Id) {
        this.player2Id = player2Id;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    public LocalDateTime getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDateTime dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}