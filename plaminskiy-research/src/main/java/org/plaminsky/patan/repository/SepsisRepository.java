package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Sepsis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SepsisRepository extends JpaRepository<Sepsis, Long> {

    @Query(value = """
            SELECT * FROM patan_spb.sepsis AS s
                    JOIN patan_spb.sepsis_type AS st ON s.sepsis_type = st.id
                    WHERE s.autopsy_id = :autopsyId
                        AND st.id = :sepsisType
            """, nativeQuery = true)
    Optional<Sepsis> findByAutopsyIdAndSepsisType(@Param("autopsyId") String autopsyId,
                                                  @Param("sepsisType") Long sepsisType);
}
