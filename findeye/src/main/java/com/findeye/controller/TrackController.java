package com.findeye.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackController {

    @GetMapping("/track")
    public String track(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        session.setAttribute("status", "🔴 Disconnected");

        model.addAttribute("status", session.getAttribute("status"));
        model.addAttribute("connected", false);
        model.addAttribute("deviceName", "--");
        model.addAttribute("signal", "--");
        model.addAttribute("battery", "--");
        model.addAttribute("location", "--");
        model.addAttribute("ringMessage", "");
        model.addAttribute("mapLink", "");

        return "track";
    }

    @GetMapping("/search")
    public String search(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        session.setAttribute("status", "🔵 Searching...");

        model.addAttribute("status", session.getAttribute("status"));
        model.addAttribute("connected", false);
        model.addAttribute("deviceName", "Scanning...");
        model.addAttribute("signal", "--");
        model.addAttribute("battery", "--");
        model.addAttribute("location", "--");
        model.addAttribute("ringMessage", "");
        model.addAttribute("mapLink", "");

        return "track";
    }

    @GetMapping("/connected")
    public String connected(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        session.setAttribute("status", "🟢 Connected");

        model.addAttribute("status", session.getAttribute("status"));
        model.addAttribute("connected", true);
        model.addAttribute("deviceName","SpecSpy Smart Glasses");
        model.addAttribute("signal", "Excellent");
        model.addAttribute("battery", "92%");
        model.addAttribute("location", "Living Room (13.6288,79.4192)");
        model.addAttribute("ringMessage", "");

        model.addAttribute("mapLink",
                "https://www.google.com/maps?q=13.6288,79.4192");

        return "track";
    }

    @GetMapping("/ring")
    public String ring(HttpSession session, Model model) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        session.setAttribute("status", "🟢 Connected");

        model.addAttribute("status", session.getAttribute("status"));
        model.addAttribute("connected", true);
        model.addAttribute("deviceName", "FindEye Smart Glasses");
        model.addAttribute("signal", "Excellent");
        model.addAttribute("battery", "92%");
        model.addAttribute("location", "Living Room (13.6288,79.4192)");
        model.addAttribute("ringMessage", "🔔 Ring Command Sent Successfully!");

        model.addAttribute("mapLink",
                "https://www.google.com/maps?q=13.6288,79.4192");

        return "track";
    }

}