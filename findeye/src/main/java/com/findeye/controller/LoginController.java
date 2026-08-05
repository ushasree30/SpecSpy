package com.findeye.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.findeye.entity.User;
import com.findeye.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", user.getName());

        // Get Bluetooth Status from Session
        String status = (String) session.getAttribute("status");

        if (status == null) {
            status = "🔴 Disconnected";
        }

        model.addAttribute("status", status);
        model.addAttribute("deviceName", "SpecSpy Smart Glasses");
        model.addAttribute("battery", "92%");
        model.addAttribute("signal", "Excellent");
        model.addAttribute("location", "Living Room");

        return "dashboard";
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session,
                            Model model) {

        User user = userService.loginUser(email, password);

        if (user != null) {

            session.setAttribute("user", user);

            // Default Bluetooth Status
            session.setAttribute("status", "🔴 Disconnected");

            return "redirect:/dashboard";
        }

        model.addAttribute("error", "Invalid Email or Password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}