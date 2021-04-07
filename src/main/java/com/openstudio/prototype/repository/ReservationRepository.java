package com.openstudio.prototype.repository;

import com.openstudio.prototype.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<List<Reservation>> findByPoolId(Long poolId);
}
