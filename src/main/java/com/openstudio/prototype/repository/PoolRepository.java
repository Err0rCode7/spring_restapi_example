package com.openstudio.prototype.repository;

import com.openstudio.prototype.domain.Pool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PoolRepository extends JpaRepository<Pool, Long> {
    @Query("select distinct p from Pool p" +
            " join fetch p.subject" +
            " where p.createdAt < :#{#currentTime} and p.closedAt > :#{#currentTime}")
    Optional<List<Pool>> findByDateTime(@Param("currentTime") LocalDateTime dateTime);
}
