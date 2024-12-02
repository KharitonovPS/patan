package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.DeceasedRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeceasedRecordRepository extends JpaRepository<DeceasedRecord, String> {
}
