package com.example.bookmyshow.exceptions;

public class SeatAlreadyPresentException extends RuntimeException {
    public SeatAlreadyPresentException(String message) {
        super(message);
    }
}
