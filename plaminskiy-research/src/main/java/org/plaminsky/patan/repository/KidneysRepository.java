package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Kidneys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidneysRepository extends JpaRepository<Kidneys, Long> {
}
