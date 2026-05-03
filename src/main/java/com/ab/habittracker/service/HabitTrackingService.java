package com.ab.habittracker.service;

import com.ab.habittracker.entity.HabitTracking;
import com.ab.habittracker.repository.HabitTrackingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HabitTrackingService {

    private final HabitTrackingRepository repository;

    public HabitTrackingService(HabitTrackingRepository repository) {
        this.repository = repository;
    }

    public HabitTracking markHabitDone(Long habitId) {

        LocalDate today = LocalDate.now();

        return repository.findByHabitIdAndDate(habitId, today)
                .map(existing -> existing) // already marked
                .orElseGet(() -> {
                    HabitTracking tracking = new HabitTracking();
                    tracking.setHabitId(habitId);
                    tracking.setDate(today);
                    tracking.setCompleted(true);
                    return repository.save(tracking);
                });
    }
}