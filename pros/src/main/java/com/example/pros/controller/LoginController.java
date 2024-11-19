package com.example.pros.controller;

import com.example.pros.model.Faculty;
import com.example.pros.model.LoginRequest;

import com.example.pros.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api") // Base URL for all requests
public class LoginController {

    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping("/login") // Make sure the POST mapping is here
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Optional<Faculty> faculty = facultyRepository.findById(loginRequest.getUsername());

        if (faculty.isPresent()) {
            if (faculty.get().getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty not found");
        }
    }
}
