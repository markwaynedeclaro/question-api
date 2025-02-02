package com.miguel.questionapi.configuration.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details from a database or other source
        if ("user".equals(username)) {
            return new User("user", "$2a$10$tB/qTfETKeBm6Kq3APe5eOtGWYqTUmJnsXxTH4N.gEiLbDd1e/LIG", Collections.emptyList()); // Example user
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}