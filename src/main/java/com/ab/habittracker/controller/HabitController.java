package com.ab.habittracker.controller;

import com.ab.habittracker.entity.Habit;
import com.ab.habittracker.entity.HabitTracking;
import com.ab.habittracker.service.HabitService;
import com.ab.habittracker.service.HabitTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;
    private final HabitTrackingService habitTrackingService;

    public HabitController(HabitService habitService, HabitTrackingService habitTrackingService) {
        this.habitService = habitService;
        this.habitTrackingService = habitTrackingService;
    }


    @PostMapping
    public Habit createHabit(@RequestBody Habit habit) {
        return habitService.createHabit(habit);
    }

    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }

    @PostMapping("/{id}/complete")
    public HabitTracking completeHabit(@PathVariable Long id) {
        return habitTrackingService.markHabitDone(id);
    }
}