package com.example_test.demo_test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example_test.demo_test.dto.UserUpdateRequest;
import com.example_test.demo_test.dto.UserCreationRequest;
import com.example_test.demo_test.entity.User;
import com.example_test.demo_test.exception.AppException;
import com.example_test.demo_test.exception.ErrorCode;
import com.example_test.demo_test.repository.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;


    public User createUser(UserCreationRequest request){
        User user = new User();
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
    }

    public User updateUser(UserUpdateRequest request, String id){
        User user = getUser(id);
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        return userRepository.save(user);

    }

    public String deleteUser(String id){
        userRepository.deleteById(id);
        return "User has been deleted";
    }
}
