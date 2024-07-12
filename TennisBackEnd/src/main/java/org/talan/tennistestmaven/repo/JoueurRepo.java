package org.talan.tennistestmaven.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.talan.tennistestmaven.model.data.Joueur;

public interface JoueurRepo extends CrudRepository<Joueur, Long> {

}


