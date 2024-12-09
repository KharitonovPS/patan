package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Brain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrainRepository extends JpaRepository<Brain, Long> {
}
