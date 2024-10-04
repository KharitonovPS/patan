package org.plaminsky.research.repository;

import org.plaminsky.research.entity.PathomorphArterioles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathomorphArteriolesRepository extends JpaRepository<PathomorphArterioles, Long> {
}
