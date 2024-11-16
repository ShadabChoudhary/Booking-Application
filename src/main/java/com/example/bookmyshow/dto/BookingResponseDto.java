package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
    private Booking booking;
    ResponseStatus responseStatus;
}
