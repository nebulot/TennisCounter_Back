package org.talan.tennistestmaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talan.tennistestmaven.model.data.Joueur;
import org.talan.tennistestmaven.model.rest.Player;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import org.talan.tennistestmaven.repo.JoueurRepo;
import org.talan.tennistestmaven.repo.MatchRepo;

import java.util.ArrayList;
import java.util.List;

//data
@Service
@Transactional
@Component
public class PlayerService {
    @Autowired
    private JoueurRepo joueurRepo;
    private MatchRepo matchCreeRepo;

    private List<Player> players = new ArrayList<>();
    private Iterable<Joueur> joueur;


    //Database

    public Joueur saveInDatabase(Player player) {
        Joueur joueur = convertToJoueur(player);
        return joueurRepo.save(joueur);
    }

    public Joueur getInDatabase(Long id){
        return joueurRepo.findById(id).orElse(null);
    }
    public Iterable<Joueur> getAllInDatabase() {
        return joueurRepo.findAll();
    }


    public void deleteInDatabase(Long id) {
        joueurRepo.deleteById(id); //=> erreur de clé
    }

    public Joueur updateInDatabase(Player player, Long id) {
        Joueur joueur= convertToJoueur(player);
        joueur.setId(id);
        return joueurRepo.save(joueur);
    }

    private Joueur convertToJoueur(Player player) {
        Joueur joueur = new Joueur();
        joueur.setId(player.getId());
        joueur.setFirstName(player.getFirstName());
        joueur.setLastName(player.getLastName());
        joueur.setBirthdate(player.getBirthdate());
        joueur.setImage(player.getImage());
        return joueur;
    }



}