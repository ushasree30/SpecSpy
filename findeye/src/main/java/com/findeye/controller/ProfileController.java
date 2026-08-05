package com.findeye.controller;

import com.findeye.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhone());

        model.addAttribute("deviceName", "SpecSpy Smart Glasses");
        model.addAttribute("status", session.getAttribute("status"));
        model.addAttribute("battery", "92%");
        model.addAttribute("signal", "Excellent");

        return "profile";
    }

}