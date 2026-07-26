package com.anar.habitflow.repository;

import com.anar.habitflow.entity.Habit;
import com.anar.habitflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {

    List<Habit> findByUser(User user);

}