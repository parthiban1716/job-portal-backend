package com.example.jobportal_backend.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal_backend.entity.User;
import com.example.jobportal_backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}