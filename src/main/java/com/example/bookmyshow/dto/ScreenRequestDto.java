package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.Feature;
import com.example.bookmyshow.models.Seat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScreenRequestDto {
    private String title;
    private int row;
    private int column;
    List<Seat> seats;
    List<String> features;
}
