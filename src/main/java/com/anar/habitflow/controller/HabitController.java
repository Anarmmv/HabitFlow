package com.anar.habitflow.controller;

import com.anar.habitflow.dto.HabitView;
import com.anar.habitflow.entity.Habit;
import com.anar.habitflow.entity.User;
import com.anar.habitflow.repository.UserRepository;
import com.anar.habitflow.service.HabitService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;
    private final UserRepository userRepository;

    public HabitController(HabitService habitService, UserRepository userRepository) {
        this.habitService = habitService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String dashboard(Model model, Authentication authentication) {
        User currentUser = getCurrentUser(authentication);

        List<Habit> habits = habitService.getHabitsForUser(currentUser);

        List<HabitView> habitViews = habits.stream()
                .map(habit -> new HabitView(
                        habit,
                        habitService.calculateCurrentStreak(habit),
                        habitService.calculateBestStreak(habit),
                        habitService.isCompletedToday(habit)
                ))
                .collect(Collectors.toList());
        model.addAttribute("habitCount",
                habitService.countHabits(currentUser));

        model.addAttribute("completedDays",
                habitService.countCompletedDays(currentUser));

        model.addAttribute("bestOverallStreak",
                habitService.calculateBestOverallStreak(currentUser));

        model.addAttribute("activeHabits",
                habitService.countActiveHabits(currentUser));

        model.addAttribute("habits", habitViews);
        return "dashboard";
    }

    @GetMapping("/new")
    public String newHabitForm() {
        return "habit-form";
    }

    @PostMapping("/new")
    public String createHabit(@RequestParam String title,
                              @RequestParam(required = false) String description,
                              Authentication authentication) {
        User currentUser = getCurrentUser(authentication);
        habitService.createHabit(currentUser, title, description);
        return "redirect:/habits";
    }

    @PostMapping("/{id}/complete")
    public String completeHabit(@PathVariable Long id, Authentication authentication) {
        User currentUser = getCurrentUser(authentication);
        habitService.completeToday(id, currentUser);
        return "redirect:/habits";
    }

    @PostMapping("/{id}/delete")
    public String deleteHabit(@PathVariable Long id, Authentication authentication) {
        User currentUser = getCurrentUser(authentication);
        habitService.deleteHabit(id, currentUser);
        return "redirect:/habits";
    }

    @PostMapping("/{id}/toggle")
    public String toggleHabit(@PathVariable Long id, Authentication authentication) {
        User currentUser = getCurrentUser(authentication);
        habitService.toggleActive(id, currentUser);
        return "redirect:/habits";
    }

    private User getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Authenticated user not found: " + username));
    }
}