package com.example.bookmyshow;

import com.example.bookmyshow.controllers.UserController;
import com.example.bookmyshow.dto.SignUpRequestDto;
import com.example.bookmyshow.dto.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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
            SignUpRequestDto requestDto = new SignUpRequestDto();
            requestDto.setName("Adnan");
            requestDto.setEmail("Adnan@gmail.com");
            requestDto.setPassword("Adnan@123");

            SignUpResponseDto signUpResponseDto = userController.signUpUser(requestDto);
        }catch (Exception e){
            System.out.println("User Already Exists");
        }

    }
}
