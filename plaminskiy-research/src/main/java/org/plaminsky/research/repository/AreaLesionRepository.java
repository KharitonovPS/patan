package org.plaminsky.research.repository;

import org.plaminsky.research.entity.AreaLesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaLesionRepository extends JpaRepository<AreaLesion, Long> {
}
