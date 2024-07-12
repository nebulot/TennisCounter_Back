package org.talan.tennistestmaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talan.tennistestmaven.model.data.Arbitre;
import org.talan.tennistestmaven.model.rest.Referee;
import org.talan.tennistestmaven.service.RefereeService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RefereeController {
    @Autowired
    private RefereeService refereeService;

    @PostMapping("/referee")
    public ResponseEntity<Arbitre> createArbitre(@RequestBody Referee referee) {
       Arbitre createdArbitre = refereeService.saveInDatabase(referee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArbitre);
    }

    @GetMapping("/referee")
    public ResponseEntity<Iterable<Arbitre>> getAllArbitre() {
        Iterable<Arbitre> arbitres = refereeService.getAllInDatabase();
        return ResponseEntity.ok(arbitres);
    }

    @GetMapping("/referee/{id}")
    public ResponseEntity<Arbitre> getArbitreById(@PathVariable Long id) {
        Arbitre arbitre = refereeService.getInDatabase(id);
        if (arbitre != null) {
            return ResponseEntity.ok(arbitre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/referee/{id}")
    public ResponseEntity<Arbitre> updateArbitre(@RequestBody Referee updatedReferee, @PathVariable Long id) {
        Arbitre updated = refereeService.updateInDatabase(updatedReferee, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/referee/{id}")
    public ResponseEntity<Void> deleteArbitre(@PathVariable Long id) {
        refereeService.deleteInDatabase(id);
        return ResponseEntity.noContent().build();
    }




}
