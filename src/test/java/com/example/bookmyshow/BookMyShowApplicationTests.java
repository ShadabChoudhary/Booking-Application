package com.example.bookmyshow;

import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dto.SignInRequestDto;
import com.example.bookmyshow.dto.SignInResponseDto;
import com.example.bookmyshow.dto.SignUpResponseDto;
import com.example.bookmyshow.exceptions.InvalidCredentialsException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowApplicationTests {

    @Autowired
    public UserController userController;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void testSignIn() throws UserNotFoundException, InvalidCredentialsException {
//        SignInRequestDto requestDto = new SignInRequestDto();
//        requestDto.setEmail("Shadab@gmail.com");
//        requestDto.setPassword("Shadab@12345");
//
//        SignInResponseDto responseDto = userController.signInUser(requestDto);
//        if(responseDto.getMessage().equals("LogIn Successful")){
//            responseDto.setMessage("Test LogIn Successful");
//        }
//    }

}
