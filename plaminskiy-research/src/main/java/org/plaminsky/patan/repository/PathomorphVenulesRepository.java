package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Liver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathomorphVenulesRepository extends JpaRepository<Liver, Long> {
}
