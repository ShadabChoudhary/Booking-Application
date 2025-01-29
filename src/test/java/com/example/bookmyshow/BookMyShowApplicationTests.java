package com.example.bookmyshow;

import com.example.bookmyshow.controllers.MovieController;
import com.example.bookmyshow.controllers.ScreenController;
import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.exceptions.InvalidCredentialsException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
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

    @Autowired
    public ScreenController screenController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSignUp(){
        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setName("Shadab");
        requestDto.setEmail("shadab@gmail.com");
        requestDto.setPassword("Shadab123");

        SignUpResponseDto responseDto = userController.signUpUser(requestDto);
        if(responseDto.getMessage().equals(ResponseStatus.SUCCESS)){
            System.out.println(responseDto.getMessage());
        }else{
            System.out.println(responseDto.getMessage());
        }
    }

    @Test
    public void testSignIn() throws UserNotFoundException, InvalidCredentialsException {
        SignInRequestDto requestDto = new SignInRequestDto();
        requestDto.setEmail("Shadab@gmail.com");
        requestDto.setPassword("Shadab123");

        SignInResponseDto responseDto = userController.signInUser(requestDto);
        if(responseDto.getMessage().equals(ResponseStatus.SUCCESS)){
            System.out.println(responseDto.getMessage());
        }else{
            System.out.println(responseDto.getMessage());
        }
    }

    @Test
    public void addMovieTest(){
        AddMovieRequestDto addMovieRequestDto = new AddMovieRequestDto();
        addMovieRequestDto.setTitle("dhoom2");
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

    @Test
    public void addScreenTest(){
        ScreenRequestDto screenRequestDto = new ScreenRequestDto();
        screenRequestDto.setTitle("Screen 1");
        List<String> featureList = new ArrayList<>();
        featureList.add("2d");
        featureList.add("3d");
        screenRequestDto.setFeatures(featureList);

        screenRequestDto.setRow(10);
        screenRequestDto.setColumn(10);

        ScreenResponseDto responseDto = screenController.addScreenDto(screenRequestDto);
        if(responseDto.getStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println(responseDto.getMessage());
        }
    }
}
