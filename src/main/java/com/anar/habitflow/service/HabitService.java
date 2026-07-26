package com.anar.habitflow.service;

import com.anar.habitflow.entity.Habit;
import com.anar.habitflow.entity.HabitCompletion;
import com.anar.habitflow.entity.User;
import com.anar.habitflow.repository.HabitCompletionRepository;
import com.anar.habitflow.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final HabitCompletionRepository habitCompletionRepository;

    public HabitService(HabitRepository habitRepository,
                        HabitCompletionRepository habitCompletionRepository) {
        this.habitRepository = habitRepository;
        this.habitCompletionRepository = habitCompletionRepository;
    }


    public Habit createHabit(User user, String title, String description) {

        Habit habit = Habit.builder()
                .title(title)
                .description(description)
                .active(true)
                .user(user)
                .build();

        return habitRepository.save(habit);
    }


    public List<Habit> getHabitsForUser(User user) {
        return habitRepository.findByUser(user);
    }


    public Habit getHabitForUser(Long habitId, User user) {

        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));


        if (!habit.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You do not have access to this habit");
        }

        return habit;
    }


    public void deleteHabit(Long habitId, User user) {

        Habit habit = getHabitForUser(habitId, user);

        habitRepository.delete(habit);
    }


    public void toggleActive(Long habitId, User user) {

        Habit habit = getHabitForUser(habitId, user);

        habit.setActive(!habit.isActive());

        habitRepository.save(habit);
    }


    public void completeToday(Long habitId, User user) {

        Habit habit = getHabitForUser(habitId, user);

        LocalDate today = LocalDate.now();


        Optional<HabitCompletion> existing =
                habitCompletionRepository.findByHabitAndCompletedDate(habit, today);


        if (existing.isPresent()) {
            return;
        }


        HabitCompletion completion = HabitCompletion.builder()
                .habit(habit)
                .completedDate(today)
                .build();


        habitCompletionRepository.save(completion);
    }


    public boolean isCompletedToday(Habit habit) {

        return habitCompletionRepository
                .findByHabitAndCompletedDate(habit, LocalDate.now())
                .isPresent();
    }



    // Yeni streak məntiqi
    // Dünən və ya bu gün ardıcıllıq yoxdursa streak sıfırlanır

    public int calculateCurrentStreak(Habit habit) {

        List<HabitCompletion> completions =
                habitCompletionRepository.findByHabitOrderByCompletedDateAsc(habit);


        if (completions.isEmpty()) {
            return 0;
        }


        Set<LocalDate> dates = new HashSet<>();

        for (HabitCompletion completion : completions) {
            dates.add(completion.getCompletedDate());
        }


        LocalDate today = LocalDate.now();


        // Bu gün də, dünən də etməyibsə streak bitib
        if (!dates.contains(today) &&
                !dates.contains(today.minusDays(1))) {

            return 0;
        }


        LocalDate cursor;


        // Bu gün edib
        if (dates.contains(today)) {

            cursor = today;

        } else {

            // Bu gün etməyib, amma dünən edib
            cursor = today.minusDays(1);

        }


        int streak = 0;


        while (dates.contains(cursor)) {

            streak++;

            cursor = cursor.minusDays(1);
        }


        return streak;
    }



    public int calculateBestStreak(Habit habit) {

        List<HabitCompletion> completions =
                habitCompletionRepository.findByHabitOrderByCompletedDateAsc(habit);


        if (completions.isEmpty()) {
            return 0;
        }


        int best = 1;
        int current = 1;

        LocalDate previous = null;


        for (HabitCompletion completion : completions) {

            LocalDate date = completion.getCompletedDate();


            if (previous != null) {

                if (date.equals(previous.plusDays(1))) {

                    current++;

                } else if (!date.equals(previous)) {

                    current = 1;
                }
            }


            best = Math.max(best, current);

            previous = date;
        }


        return best;
    }
}