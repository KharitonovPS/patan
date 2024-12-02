package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Lung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryStudyRepository extends JpaRepository<Lung, Long> {
}
