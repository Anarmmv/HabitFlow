package com.anar.habitflow.repository;

import com.anar.habitflow.entity.Habit;
import com.anar.habitflow.entity.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitCompletionRepository extends JpaRepository<HabitCompletion, Long> {

    Optional<HabitCompletion> findByHabitAndCompletedDate(Habit habit, LocalDate completedDate);

    List<HabitCompletion> findByHabitOrderByCompletedDateAsc(Habit habit);

}