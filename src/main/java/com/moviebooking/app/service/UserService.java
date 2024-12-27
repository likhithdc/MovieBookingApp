package com.moviebooking.app.service;

import com.moviebooking.app.model.User;
import com.moviebooking.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

}