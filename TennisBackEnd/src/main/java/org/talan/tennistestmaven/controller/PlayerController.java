package org.talan.tennistestmaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talan.tennistestmaven.model.data.Joueur;
import org.talan.tennistestmaven.model.rest.Player;
import org.talan.tennistestmaven.service.PlayerService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Database
    @PostMapping("/player")
    public ResponseEntity<Joueur> createJoueur(@RequestBody Player player) {
        Joueur createdJoueur = playerService.saveInDatabase(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJoueur);
    }

    @GetMapping("/player")
    public ResponseEntity<Iterable<Joueur>> getAllJoueurs() {
        Iterable<Joueur> joueurs = playerService.getAllInDatabase();
        return ResponseEntity.ok(joueurs);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Joueur> getJoueursById(@PathVariable Long id) {
        Joueur joueur = playerService.getInDatabase(id);
        if (joueur != null) {
            return ResponseEntity.ok(joueur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/player/{id}")
    public ResponseEntity<Joueur> updateJoueur(@RequestBody Player updatedPlayer, @PathVariable Long id) {
        Joueur updated = playerService.updateInDatabase(updatedPlayer, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Void> deleteJoueur(@PathVariable Long id) {
        playerService.deleteInDatabase(id);
        return ResponseEntity.noContent().build();
    }
}