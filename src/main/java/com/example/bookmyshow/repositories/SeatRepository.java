package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findBySeatNumberAndId(String seatNumber, long screenId);
}
