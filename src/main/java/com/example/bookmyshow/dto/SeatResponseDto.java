package com.example.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatResponseDto {
    private int seatId;
    private String message;
    ResponseStatus status;
}
