package com.example_test.demo_test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example_test.demo_test.dto.UserUpdateRequest;
import com.example_test.demo_test.dto.ApiResponse;
import com.example_test.demo_test.dto.UserCreationRequest;
import com.example_test.demo_test.entity.User;
import com.example_test.demo_test.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServicesRequest;
    
    @PostMapping
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User>apiResponse = new ApiResponse<>();

        apiResponse.setResult(userServicesRequest.createUser(request));
        return apiResponse;

    }

    @GetMapping
    public List<User>getUser(){
        return userServicesRequest.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return userServicesRequest.getUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody UserUpdateRequest updateUser,@PathVariable String userId){
        return userServicesRequest.updateUser(updateUser,userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){
        userServicesRequest.deleteUser(userId);
    }
}
