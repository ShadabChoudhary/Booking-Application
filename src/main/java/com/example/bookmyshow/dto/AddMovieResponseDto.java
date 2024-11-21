package com.example.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMovieResponseDto {
    private Long movieId;
    private ResponseStatus status;
    private String message;
}
