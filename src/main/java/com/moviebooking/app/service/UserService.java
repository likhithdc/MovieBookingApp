package com.moviebooking.app.service;

import com.moviebooking.app.model.User;
import com.moviebooking.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    // Create or register a new user

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    // Fetch a user by username

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean authenticateUser(String username, String password) {
        //find user by username
        Optional<User> optionalUser = userRepository.findByUsername(username);
        //check if user exists and validate password
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("user with Id " + id + "not found");
        }
    }

}