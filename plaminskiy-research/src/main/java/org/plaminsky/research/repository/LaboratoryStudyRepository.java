package org.plaminsky.research.repository;

import org.plaminsky.research.entity.LaboratoryStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryStudyRepository extends JpaRepository<LaboratoryStudy, Long> {
}
