package com.example_test.demo_test.dto;

import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    private String username;
    private String fullName;

    @Size(min = 8, message = "PASWORD_INVALID")
    private String password;
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
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
