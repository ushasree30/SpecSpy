package com.findeye.controller;

import com.findeye.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String settings(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("name", user.getName());

        model.addAttribute("notifications", "ON");
        model.addAttribute("darkMode", "OFF");
        model.addAttribute("language", "English");
        model.addAttribute("bluetooth", "Auto Connect");
        model.addAttribute("volume", "80%");

        return "settings";
    }

}