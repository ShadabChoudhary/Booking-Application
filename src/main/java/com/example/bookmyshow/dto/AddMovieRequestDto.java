package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.Feature;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AddMovieRequestDto {
    private String title;
    private String description;
    private String releaseDate;
    private List<Feature> features;
}
