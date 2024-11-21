package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.MovieAlreadyExistException;
import com.example.bookmyshow.models.Feature;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(String title, String description, String releaseDate, List<Feature> features) throws MovieAlreadyExistException {

        //Parsing the releaseDate String to LocalDate
        LocalDate parsedReleaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Optional<Movie> movieOptional = movieRepository.findByTitleAndAndReleaseDate(title, parsedReleaseDate);
        Movie movie = new Movie();

        if(movieOptional.isEmpty()){
            movie.setTitle(title);
            movie.setReleaseDate(parsedReleaseDate);
            movie.setDescription(description);
            movie.setFeatures(features);
            movieRepository.save(movie);
        }else{
            throw new MovieAlreadyExistException("Movie already exist with this title");
        }
        return movie;
    }

}
