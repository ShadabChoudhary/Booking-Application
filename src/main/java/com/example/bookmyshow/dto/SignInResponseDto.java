package com.example.bookmyshow.dto;

import com.example.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponseDto {
    private User user;
    private ResponseStatus responseStatus;
}
