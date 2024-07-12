package org.talan.tennistestmaven.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.talan.tennistestmaven.model.rest.*;
import org.talan.tennistestmaven.model.data.*;
import org.talan.tennistestmaven.repo.MatchRepo;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Component
public class MatchService {
    private List<Match> matchs = new ArrayList<>();

    @Autowired
    private MatchRepo matchRepo;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private RefereeService refereeService;


    public Match saveInDatabase(MatchCreate match) {
        Match matchCree = convertToMatchCree(match);
        return matchRepo.save(matchCree);
    }

    public Match getInDatabase(Long id) {
        return matchRepo.findById(id).orElse(null);
    }

    public Iterable<Match> getAllInDatabase() {
        return matchRepo.findAll();
    }

    private Match convertToMatchCree(MatchCreate match) {
        Match matchCree = new Match();
        if (match.getId() != null) {
            matchCree.setId(match.getId());
        }
        matchCree.setPlayer1Id(match.getPlayer1Id());
        matchCree.setPlayer2Id(match.getPlayer2Id());
        matchCree.setRefereeId(match.getRefereeId());
        matchCree.setDateBegin(match.getDateBegin());
        return matchCree;
    }


    public Iterable<MatchEdit> findAll() {
        Iterable<Match> matches = matchRepo.findAll();
        List<MatchEdit> matchEdits = new ArrayList<>();

        for (Match match : matches) {
            MatchEdit matchEdit = new MatchEdit();

            matchEdit.setPlayer1(playerService.getInDatabase(match.getPlayer1Id()));
            matchEdit.setPlayer2(playerService.getInDatabase(match.getPlayer2Id()));
            matchEdit.setReferee(refereeService.getInDatabase(match.getRefereeId()));
            matchEdit.setDateBegin(match.getDateBegin());
            matchEdits.add(matchEdit);
        }
        return matchEdits;
    }
}