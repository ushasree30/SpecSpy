package com.findeye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findeye.entity.User;
import com.findeye.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Login User
    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            System.out.println("User not found");
            return null;
        }

        System.out.println("Database Password: " + user.getPassword());
        System.out.println("Entered Password : " + password);

        if (user.getPassword().equals(password)) {
            System.out.println("Login Successful");
            return user;
        }

        System.out.println("Password does not match");
        return null;
    }
}