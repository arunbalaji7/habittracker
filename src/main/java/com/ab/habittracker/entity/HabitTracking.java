package com.ab.habittracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "habit_trackings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long habitId;

    private LocalDate date;

    private boolean completed;
}