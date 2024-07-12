package org.talan.tennistestmaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.talan.tennistestmaven.model.rest.Score;
import org.talan.tennistestmaven.service.ScoreService;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/match/score")
    public Score updateScore(@RequestBody Map<String, String> payload) {
        String player = payload.get("player");
        return scoreService.updateScore(player);
    }

}