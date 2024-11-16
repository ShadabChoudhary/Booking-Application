package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private User user;
    private String message;
    private ResponseStatus responseStatus;
}
