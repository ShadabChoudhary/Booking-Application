package com.example.bookmyshow;

import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dto.SignInRequestDto;
import com.example.bookmyshow.dto.SignInResponseDto;
import com.example.bookmyshow.dto.SignUpRequestDto;
import com.example.bookmyshow.dto.SignUpResponseDto;
import com.example.bookmyshow.exceptions.InvalidCredentialsException;
import com.example.bookmyshow.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            Scanner sc = new Scanner(System.in);

            System.out.println("-----SignUp------");
            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Confirm Password: ");
            String password = sc.nextLine();

            SignUpRequestDto requestDto = new SignUpRequestDto();
            requestDto.setName(username);
            requestDto.setEmail(email);
            requestDto.setPassword(password);
            try {
                SignUpResponseDto signUpResponseDto = userController.signUpUser(requestDto);
                System.out.println(signUpResponseDto.getMessage());
            }catch (UserAlreadyExistException ue){
                System.out.println("Error: "+ue.getMessage());
            }

            //SignIn process
            System.out.println("\n-----SignIn------");
            System.out.print("Enter Email: ");
            String logInMail = sc.nextLine();

            System.out.print("Enter Password: ");
            String logInPassword = sc.nextLine();

            SignInRequestDto signInRequestDto = new SignInRequestDto();
            signInRequestDto.setEmail(logInMail);
            signInRequestDto.setPassword(logInPassword);
            try{
                SignInResponseDto signInResponseDto = userController.signInUser(signInRequestDto);
                System.out.println(signInResponseDto.getMessage());
            }catch(InvalidCredentialsException ie){
                throw new InvalidCredentialsException("Error: " + ie.getMessage());
            }

        }catch (Exception e){
            System.out.println("An error occurred while reading the input: "+e.getMessage());
        }

    }
}
