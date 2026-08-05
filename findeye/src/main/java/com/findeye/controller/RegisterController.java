package com.findeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.findeye.entity.User;
import com.findeye.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    // Open Register Page
    @GetMapping("/register")
    public String registerPage() {

        System.out.println("REGISTER PAGE OPENED");

        return "register";
    }

    // Save User
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, Model model) {

        System.out.println("===== REGISTER =====");
        System.out.println("Name     : " + user.getName());
        System.out.println("Email    : " + user.getEmail());
        System.out.println("Phone    : " + user.getPhone());
        System.out.println("Password : " + user.getPassword());

        userService.saveUser(user);

        model.addAttribute("message", "Registration Successful!");

        return "register";
    }
}