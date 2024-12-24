package com.moviebooking.app.service;

import com.moviebooking.app.model.User;
import com.moviebooking.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = new User();
        user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email + " Not Found");
        } else {
        }
        return null;
    }

}