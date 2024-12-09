package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Lungs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LungsRepository extends JpaRepository<Lungs, Long> {
}
