package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    @Override
    Optional<Show> findById(Long aLong);
//    Optional<Show> findExistShow(Long movieId, Long screenId, int startTime);
}
