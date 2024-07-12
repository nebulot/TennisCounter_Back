package org.talan.tennistestmaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talan.tennistestmaven.model.data.*;
import org.talan.tennistestmaven.model.rest.*;
import org.talan.tennistestmaven.repo.MatchRepo;
import org.talan.tennistestmaven.service.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private MatchRepo repo;

    @Autowired
    private ScoreService scoreService;

    //Post du MatchCree
    @PostMapping("/match")
    public void createMatch(@RequestBody MatchCreate matchCreate) {
        matchService.saveInDatabase(matchCreate);
    }

       /*@PostMapping("/match/score")
    public ResponseEntity<Score> updateScore(@RequestBody Map<String, String> payload) {
        String player1Name = payload.get("player1Name");
        String player2Name = payload.get("player2Name");

        // Exemple : Comment gérer les deux joueurs
        Score updatedMatch = scoreService.updateScore(player1Name, player2Name);
        if (updatedMatch != null) {
            return ResponseEntity.ok(updatedMatch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping("/match")
    public ResponseEntity<Iterable<MatchEdit>> getAllMatch() {
        Iterable<Match> matchEdits = matchService.getAllInDatabase();
        //return ResponseEntity.ok(matchs);
        return ResponseEntity.ok(matchService.findAll());
    }

    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Match match = matchService.getInDatabase(id);
        if (match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}