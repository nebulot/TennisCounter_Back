package org.talan.tennistestmaven.repo;

import org.springframework.data.repository.CrudRepository;
import org.talan.tennistestmaven.model.data.Match;

public interface MatchRepo extends CrudRepository<Match, Long>{

}
