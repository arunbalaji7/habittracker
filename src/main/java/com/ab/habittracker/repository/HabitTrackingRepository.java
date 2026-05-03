package com.ab.habittracker.repository;

import com.ab.habittracker.entity.HabitTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface HabitTrackingRepository extends JpaRepository<HabitTracking, Long> {

    Optional<HabitTracking> findByHabitIdAndDate(Long habitId, LocalDate date);
}