package com.example.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenResponseDto {
    private long screenId;
    private String message;
    private ResponseStatus status;
}
