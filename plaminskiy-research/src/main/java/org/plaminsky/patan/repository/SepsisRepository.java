package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Sepsis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SepsisRepository extends JpaRepository<Sepsis, Long> {


    Optional<Sepsis> findByAutopsyId(String autopsyId);
}
