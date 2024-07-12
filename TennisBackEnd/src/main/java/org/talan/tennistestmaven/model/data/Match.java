package org.talan.tennistestmaven.model.data;


import jakarta.persistence.*;
import org.talan.tennistestmaven.model.rest.Player;
import org.talan.tennistestmaven.model.rest.Referee;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "td_match", schema = "i_match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_match")
    @SequenceGenerator(name = "id_match", sequenceName = "id_match_seq", schema = "i_match", allocationSize = 1)
    @Column(name = "id_match")
    private Long id;

    @Column(name = "id_player1")
    private Long player1Id;

    @Column(name = "id_player2")
    private Long player2Id;

    @Column(name = "id_referee")
    private Long refereeId;

    @Column(name = "date_start_match")
    private LocalDateTime dateBegin;

    // Constructeur par défaut
    public Match() {

    }



    public long getId() {
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

    public long getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Long player2Id) {
        this.player2Id = player2Id;
    }

    public long getRefereeId() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}