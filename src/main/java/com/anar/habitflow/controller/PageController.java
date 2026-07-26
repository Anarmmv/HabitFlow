package com.anar.habitflow.controller;

import com.anar.habitflow.entity.User;
import com.anar.habitflow.service.HabitService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final HabitService habitService;

    public PageController(HabitService habitService) {
        this.habitService = habitService;
    }


    @GetMapping("/statistics")
    public String statistics(Model model, Authentication authentication) {

        model.addAttribute("message",
                "Statistics page coming soon");

        return "statistics";
    }


    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {

        model.addAttribute("username",
                authentication.getName());

        return "profile";
    }
}