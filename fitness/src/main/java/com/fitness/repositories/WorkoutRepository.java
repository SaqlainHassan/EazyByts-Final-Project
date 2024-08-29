package com.fitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.models.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
