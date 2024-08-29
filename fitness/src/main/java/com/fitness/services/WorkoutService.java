package com.fitness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.models.Workout;
import com.fitness.repositories.WorkoutRepository;

@Service
public class WorkoutService {
	
	 @Autowired
	 private WorkoutRepository workoutRepository;

	 public List<Workout> getAllWorkouts() {
	     return workoutRepository.findAll();
	 }

	 public Workout getWorkoutById(Long id) {
	     return workoutRepository.findById(id).orElse(null);
	 }

	 public Workout saveWorkout(Workout workout) {
	     return workoutRepository.save(workout);
	 }

	 public void deleteWorkout(Long id) {
	     workoutRepository.deleteById(id);
	 }

}
