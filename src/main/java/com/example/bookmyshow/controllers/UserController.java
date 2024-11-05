package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.SignUpRequestDto;
import com.example.bookmyshow.dto.SignUpResponseDto;
import com.example.bookmyshow.exceptions.UserAlreadyExistException;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUpUser(SignUpRequestDto signUpRequestDto) throws UserAlreadyExistException {
        User user = userService.signUp(
                signUpRequestDto.getName(),
                signUpRequestDto.getEmail(),
                signUpRequestDto.getPassword()
        );

        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        signUpResponseDto.setUser(user);
        return signUpResponseDto;
    }
}
