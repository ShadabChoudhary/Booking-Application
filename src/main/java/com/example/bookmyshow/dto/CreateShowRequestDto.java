package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.Feature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShowRequestDto {
    private Long movieId;
    private Long screenId;
    private int startTime;
    private int endTime;
    private Feature feature;
    private Long userId;//only for user authentication
}
