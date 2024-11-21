package com.example.bookmyshow;

import com.example.bookmyshow.controllers.MovieController;
import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.models.Feature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BookMyShowApplicationTests {

    @Autowired
    public UserController userController;

    @Autowired
    public MovieController movieController;

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

    @Test
    public void addMovieTest(){
        AddMovieRequestDto addMovieRequestDto = new AddMovieRequestDto();
        addMovieRequestDto.setTitle("dhoom");
        addMovieRequestDto.setDescription("enfeknewvnejwvnejrvnrnv");
        addMovieRequestDto.setReleaseDate("2001-08-24");//format - yyyy-MM-dd

        //adding list of features
        List<Feature> featureList = new ArrayList<>();
        featureList.add(Feature.TWO_D);
        featureList.add(Feature.THREE_D);
        addMovieRequestDto.setFeatures(featureList);

        AddMovieResponseDto addMovieResponseDto = movieController.responseDto(addMovieRequestDto);
        System.out.println(addMovieResponseDto.getMessage());
    }
}
