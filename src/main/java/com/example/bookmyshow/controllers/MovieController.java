package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.AddMovieRequestDto;
import com.example.bookmyshow.dto.AddMovieResponseDto;
import com.example.bookmyshow.dto.ResponseStatus;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.service.MovieService;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public AddMovieResponseDto responseDto(AddMovieRequestDto addMovieRequestDto) {
        AddMovieResponseDto addMovieResponseDto = new AddMovieResponseDto();
        try{
            Movie movie = movieService.addMovie(
                    addMovieRequestDto.getTitle(),
                    addMovieRequestDto.getDescription(),
                    addMovieRequestDto.getReleaseDate(),
                    addMovieRequestDto.getFeatures()
            );
            addMovieResponseDto.setMovieId(movie.getId());
            addMovieResponseDto.setStatus(ResponseStatus.SUCCESS);
            addMovieResponseDto.setMessage("Movie added successfully");
        }catch (Exception e){
            addMovieResponseDto.setStatus(ResponseStatus.FAILURE);
            addMovieResponseDto.setMessage(e.getMessage());
        }
        return addMovieResponseDto;
    }
}
