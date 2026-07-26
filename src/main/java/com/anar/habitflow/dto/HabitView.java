package com.anar.habitflow.dto;

import com.anar.habitflow.entity.Habit;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HabitView {

    private final Habit habit;
    private final int currentStreak;
    private final int bestStreak;
    private final boolean completedToday;
}