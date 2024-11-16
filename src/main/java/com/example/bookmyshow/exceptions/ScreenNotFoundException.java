package com.example.bookmyshow.exceptions;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class ScreenNotFoundException extends Exception {
    public ScreenNotFoundException(String message) {
        super(message);
    }
}
