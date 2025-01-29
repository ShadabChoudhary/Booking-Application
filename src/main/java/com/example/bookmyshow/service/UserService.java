package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.InvalidCredentialsException;
import com.example.bookmyshow.exceptions.UserAlreadyExistException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;
    final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(String username, String emailId, String password) throws UserAlreadyExistException {

        Optional<User> optionalUser = userRepository.findByEmail(emailId);
        User user = new User();
        if(optionalUser.isEmpty()){
            user.setName(username);
            user.setEmail(emailId);
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }else{
            throw new UserAlreadyExistException("User Already Exist");
        }
        return user;
    }

    public User signIn(String username, String password) throws UserNotFoundException, InvalidCredentialsException {
        Optional<User> userOptional = userRepository.findByEmail(username);

        if(userOptional.isEmpty()){
            throw new UserNotFoundException("No User found with this Email");
        }

        //if email already registered
        User user = userOptional.get();
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new InvalidCredentialsException("Email or Password is incorrect");
        }
        return user;
    }
}
