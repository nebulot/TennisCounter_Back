package org.talan.tennistestmaven.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.talan.tennistestmaven.model.data.Login;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {
    Optional<Login> findByUsername(String username);
}