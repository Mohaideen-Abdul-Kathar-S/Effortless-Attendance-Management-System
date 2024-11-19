package com.example.pros.service;

import com.example.pros.model.User;
import com.example.pros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            return userRepository.save(user);
        } else {
            return null; // User already exists
        }
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user; // Login successful
        } else {
            return null; // Login failed
        }
    }
}
