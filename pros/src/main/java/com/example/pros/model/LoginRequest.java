package com.example.pros.model;



public class LoginRequest {
    private String username;  // Faculty ID
    private String password;  // Password

    // Default constructor
    public LoginRequest() {}

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
