package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.BookingRequestDto;
import com.example.bookmyshow.dto.BookingResponseDto;
import com.example.bookmyshow.service.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookingResponseDto BookingTicket(BookingRequestDto bookingRequestDto) {
        return null;
    }
}
