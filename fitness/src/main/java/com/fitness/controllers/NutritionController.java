package com.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fitness.models.Nutrition;
import com.fitness.services.NutritionService;

@Controller
@RequestMapping("/nutrition")
public class NutritionController {
	
	@Autowired
    private NutritionService nutritionService;

    @GetMapping
    public String listNutritionPlans(Model model) {
        model.addAttribute("nutritionPlans", nutritionService.getAllNutritions());
        return "nutrition_plans";
    }

    @GetMapping("/new")
    public String showNewNutritionForm(Model model) {
        model.addAttribute("nutrition", new Nutrition());
        return "nutrition_form";
    }

    @PostMapping
    public String saveNutrition(@ModelAttribute("nutrition") Nutrition nutrition) {
        nutritionService.saveNutrition(nutrition);
        return "redirect:/nutrition";
    }

    @GetMapping("/edit/{id}")
    public String showEditNutritionForm(@PathVariable Long id, Model model) {
        model.addAttribute("nutrition", nutritionService.getNutritionById(id));
        return "nutrition_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteNutrition(@PathVariable Long id) {
        nutritionService.deleteNutrition(id);
        return "redirect:/nutrition";
    }

}
