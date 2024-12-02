package org.plaminsky.patan.repository;

import org.plaminsky.patan.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathomorphArteriolesRepository extends JpaRepository<Heart, Long> {
}
