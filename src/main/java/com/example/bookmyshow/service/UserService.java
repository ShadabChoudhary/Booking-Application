package com.example.bookmyshow.service;

import com.example.bookmyshow.exceptions.UserAlreadyExistException;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(String username, String emailId, String password) throws UserAlreadyExistException {

        Optional<User> optionalUser = userRepository.findByEmail(emailId);
        User user = null;
        if(optionalUser.isEmpty()){
            user = new User();
            user.setName(username);
            user.setEmail(emailId);
            user.setPassword(passwordEncoder.encode(password));

            userRepository.save(user);
        }else{
            throw new UserAlreadyExistException("User Already Exist");
        }
        return user;
    }
}
