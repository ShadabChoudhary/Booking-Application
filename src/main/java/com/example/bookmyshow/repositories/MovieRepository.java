package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    Optional<Movie> findById(Long aLong);

    @Query("select m FROM Movie m WHERE m.title = :title AND m.releaseDate = :releaseDate")
    Optional<Movie> findByTitleAndAndReleaseDate(@Param("title") String title, @Param("releaseDate") LocalDate releaseDate);
}
