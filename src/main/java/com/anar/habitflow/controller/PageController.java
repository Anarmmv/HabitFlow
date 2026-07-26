package com.anar.habitflow.controller;
import com.anar.habitflow.service.UserService;
import com.anar.habitflow.entity.User;
import com.anar.habitflow.service.HabitService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    private final HabitService habitService;
    private final UserService userService;

    public PageController(HabitService habitService,
                          UserService userService) {
        this.habitService = habitService;
        this.userService = userService;
    }

    @GetMapping("/statistics")
    public String statistics(Model model, Authentication authentication) {

        User user = userService.findByUsername(authentication.getName());

        model.addAttribute("totalHabits",
                habitService.countHabits(user));

        model.addAttribute("activeHabits",
                habitService.countActiveHabits(user));

        model.addAttribute("completedDays",
                habitService.countCompletedDays(user));

        model.addAttribute("bestStreak",
                habitService.calculateBestOverallStreak(user));

        return "statistics";
    }


    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {

        model.addAttribute("username",
                authentication.getName());

        return "profile";
    }
}