package org.talan.tennistestmaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talan.tennistestmaven.model.data.Arbitre;
import org.talan.tennistestmaven.model.rest.Referee;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import org.talan.tennistestmaven.repo.ArbitreRepo;
import org.talan.tennistestmaven.repo.MatchRepo;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Component
public class RefereeService {

    @Autowired
    private ArbitreRepo arbitreRepo;
    private MatchRepo matchCreeRepo;

    private List<Referee> referees = new ArrayList<>(); // on doit le généraliser à chaque formulaire nouvel ArrayList
    private Iterable<Arbitre> arbitre;


    //Database

    public Arbitre saveInDatabase(Referee referee) {
        Arbitre arbitre = convertToArbitre(referee);
        return arbitreRepo.save(arbitre);
    }

    public Arbitre getInDatabase(Long id) {
        return arbitreRepo.findById(id).orElse(null);
    }

    public Iterable<Arbitre> getAllInDatabase() {
        return arbitreRepo.findAll();
    }


    public void deleteInDatabase(Long id) {
        arbitreRepo.deleteById(id); //=> erreur de clé
    }

    public Arbitre updateInDatabase(Referee referee, Long id) {
        Arbitre arbitre = convertToArbitre(referee);
        arbitre.setId(id);
        return arbitreRepo.save(arbitre);
    }

    private Arbitre convertToArbitre(Referee referee) {
        Arbitre arbitre = new Arbitre();
        arbitre.setId(referee.getId());
        arbitre.setFirstName(referee.getFirstName());
        arbitre.setLastName(referee.getLastName());
        arbitre.setBirthdate(referee.getBirthdate());
        arbitre.setImage(referee.getImage());
        return arbitre;
    }

}