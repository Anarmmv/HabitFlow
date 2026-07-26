package com.anar.habitflow.controller;

import com.anar.habitflow.dto.RegisterRequest;
import com.anar.habitflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute RegisterRequest registerRequest) {

        userService.register(registerRequest);

        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}