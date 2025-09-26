package com.example.software_manager.Service;

import com.example.software_manager.Model.User;
import com.example.software_manager.Repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> listUsers(Long userId){
        if(userId != null){
            return userRepository.findAllByUserId(userId);
        }
        return userRepository.findAll();
    }
    public User saveUser(String nome, String email, String password, String image){
        User user = new User();

        return null;
    }
}
