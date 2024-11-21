package com.example.bookmyshow;

import com.example.bookmyshow.controllers.MovieController;
import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dto.*;
import com.example.bookmyshow.exceptions.InvalidCredentialsException;
import com.example.bookmyshow.models.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication {

    @Autowired
    UserController userController;

    @Autowired
    MovieController movieController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        try{
//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("-----SignUp------");
//            System.out.print("Enter Username: ");
//            String username = sc.nextLine();
//
//            System.out.print("Enter Email: ");
//            String email = sc.nextLine();
//
//            System.out.print("Enter Password: ");
//            String password = sc.nextLine();
//
//            SignUpRequestDto requestDto = new SignUpRequestDto();
//            requestDto.setName(username);
//            requestDto.setEmail(email);
//            requestDto.setPassword(password);
//            try {
//                SignUpResponseDto signUpResponseDto = userController.signUpUser(requestDto);
//                System.out.println(signUpResponseDto.getMessage());
//            }catch (Exception e){
//                System.out.println("Error: "+e.getMessage());
//            }
//
//            //SignIn process
//            System.out.println("\n-----SignIn------");
//            System.out.print("Enter Email: ");
//            String logInMail = sc.nextLine();
//
//            System.out.print("Enter Password: ");
//            String logInPassword = sc.nextLine();
//
//            SignInRequestDto signInRequestDto = new SignInRequestDto();
//            signInRequestDto.setEmail(logInMail);
//            signInRequestDto.setPassword(logInPassword);
//            try{
//                SignInResponseDto signInResponseDto = userController.signInUser(signInRequestDto);
//                System.out.println(signInResponseDto.getMessage());
//
//                //Select Options
//                boolean exit = false;
//                while(!exit){
//                    System.out.println("\n-----Select and Option:------");
//                    System.out.println("1. Create Show");
//                    System.out.println("2. Get Show details");
//                    System.out.println("3. Add Movie");
//                    System.out.println("4. Exit");
//
//                    System.out.print("Enter Choice: ");
//                    int choice = sc.nextInt();
//                    switch(choice){
//                        case 1:
//                            createShowProcess(sc);
//                            break;
//                        case 2:
//                            getShowProcess(sc);
//                            break;
//                        case 3:
//                            addMovieProcess(sc);
//                            break;
//                        case 4:
//                            exit = true;
//                            System.out.println("Exit");
//                            break;
//                        default:
//                            System.out.println("Invalid Choice, Please try again");
//                    }
//                }
//            }catch(Exception e){
//                throw new InvalidCredentialsException("Error: " + e.getMessage());
//            }
//
//        }catch (Exception e){
//            System.out.println("An error occurred while reading the input: "+e.getMessage());
//        }
//    }

    public void addMovieProcess(Scanner sc){
//        System.out.println("Add Movie: ");
//        System.out.print("Enter Movie title: ");
//        String movieTitle = sc.nextLine();
//
//        System.out.print("Enter Description: ");
//        String movieDescription = sc.nextLine();
//
//        System.out.print("Enter Release Date (yyyy-MM-dd): ");
//        String releaseDate = sc.nextLine();
//        Date date = null;
//        try{
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            date = dateFormat.parse(releaseDate);
//        }catch (Exception e){
//            System.out.println("Error: "+e.getMessage());
//        }
//
//        System.out.print("Enter number of Features: ");
//        int numberOfFeatures = sc.nextInt();
//        List<Feature> featureList = new ArrayList<>();
//        for(int i = 0; i<numberOfFeatures; i++){
//            System.out.print("Enter Feature: ");
//            String featureName = sc.nextLine();
//
//            try{
//                Feature feature = Feature.valueOf(featureName.toUpperCase());
//                featureList.add(feature);
//            }catch (Exception e){
//                System.out.println("Invalid Feature: "+featureName);
//            }
//        }
//
//        AddMovieRequestDto requestDto = new AddMovieRequestDto();
//        requestDto.setTitle(movieTitle);
//        requestDto.setDescription(movieDescription);
//        requestDto.setReleaseDate(date);
//        requestDto.setFeatures(featureList);
//
//        try{
//            AddMovieResponseDto movieResponse = movieController.responseDto(requestDto);
//            System.out.println(movieResponse.getMessage());
//        }catch (Exception e){
//            System.out.println("Error: "+e.getMessage());
//        }
//
    }

//    public void createShowProcess(Scanner sc){
//        System.out.println("Create a Show: ");
//        System.out.println("Enter Show Name: ");
//        String movieName = sc.nextLine();
//
//        System.out.println("Enter Screen: ");
//        String screenName = sc.nextLine();
//
//        System.out.println("Enter Start Time: ");
//        int startTime = sc.nextInt();
//
//        System.out.println("Enter End Time: ");
//        int endTime = sc.nextInt();
//
//        System.out.println("Enter Feature: ");
//        String feature = sc.nextLine();
//    }

//    public void getShowProcess(Scanner sc){
//
//    }
}
