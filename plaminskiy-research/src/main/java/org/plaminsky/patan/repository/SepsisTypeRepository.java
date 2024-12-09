package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.SepsisType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SepsisTypeRepository extends JpaRepository<SepsisType, Long> {
}
