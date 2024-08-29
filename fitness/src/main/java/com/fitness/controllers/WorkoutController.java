package com.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitness.models.Workout;
import com.fitness.services.WorkoutService;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {

	@Autowired
    private WorkoutService workoutService;

    @GetMapping
    public String listWorkouts(Model model) {
        model.addAttribute("workouts", workoutService.getAllWorkouts());
        return "workout_plans";
    }

    @GetMapping("/new")
    public String showNewWorkoutForm(Model model) {
        model.addAttribute("workout", new Workout());
        return "workout_form";
    }

    @PostMapping
    public String saveWorkout(@ModelAttribute("workout") Workout workout) {
        workoutService.saveWorkout(workout);
        return "redirect:/workouts";
    }

    @GetMapping("/edit/{id}")
    public String showEditWorkoutForm(@PathVariable Long id, Model model) {
        model.addAttribute("workout", workoutService.getWorkoutById(id));
        return "workout_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return "redirect:/workouts";
    }
}
