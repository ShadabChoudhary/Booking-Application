package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.exceptions.InvalidCredentialsException;
import com.example.bookmyshow.exceptions.UserAlreadyExistException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUpUser(SignUpRequestDto signUpRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try{
            User user = userService.signUp(
                    signUpRequestDto.getName(),
                    signUpRequestDto.getEmail(),
                    signUpRequestDto.getPassword()
            );
            signUpResponseDto.setUser(user);
            signUpResponseDto.setMessage("Sign up successful");
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            signUpResponseDto.setMessage("Sign up failed");
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return signUpResponseDto;
    }

    public SignInResponseDto signInUser(SignInRequestDto signInRequestDto) {

        SignInResponseDto signInResponseDto = new SignInResponseDto();
        try{
            User user = userService.signIn(signInRequestDto.getEmail(), signInRequestDto.getPassword());
            signInResponseDto.setUser(user);
            signInResponseDto.setMessage("Sign in successful");
            signInResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            signInResponseDto.setMessage("Sign in failed");
            signInResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signInResponseDto;
    }
}
