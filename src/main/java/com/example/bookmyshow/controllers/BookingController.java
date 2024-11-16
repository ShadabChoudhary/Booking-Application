package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.BookingRequestDto;
import com.example.bookmyshow.dto.BookingResponseDto;
import com.example.bookmyshow.dto.ResponseStatus;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.service.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookingResponseDto BookingTicket(BookingRequestDto bookingRequestDto) {
       BookingResponseDto bookingResponseDto = new BookingResponseDto();
       try{
           Booking booking = bookingService.Book(
                   bookingRequestDto.getUserId(),
                   bookingRequestDto.getShowId(),
                   bookingRequestDto.getSeatIds()
           );
            bookingResponseDto.setBooking(booking);
            bookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
       }catch (Exception e){
           bookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
       }

       return bookingResponseDto;
    }
}
