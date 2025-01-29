package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatRequestDto {
    private int rowVal;
    private int colVal;
    private SeatType seatType;
}
