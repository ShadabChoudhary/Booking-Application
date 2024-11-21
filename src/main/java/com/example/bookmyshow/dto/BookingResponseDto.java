package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
    private Booking booking;
    ResponseStatus responseStatus;
}
