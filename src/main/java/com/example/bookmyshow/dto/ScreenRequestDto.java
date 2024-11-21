package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.Feature;
import com.example.bookmyshow.models.Seat;

import java.util.List;

public class ScreenRequestDto {
    private String title;
    private List<Seat> seats;
    private List<Feature> features;
}
