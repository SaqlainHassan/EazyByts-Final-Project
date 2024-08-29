package com.fitness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.models.Nutrition;
import com.fitness.repositories.NutritionRepository;

@Service
public class NutritionService {
	
	@Autowired
    private NutritionRepository nutritionRepository;

    public List<Nutrition> getAllNutritions() {
        return nutritionRepository.findAll();
    }

    public Nutrition getNutritionById(Long id) {
        return nutritionRepository.findById(id).orElse(null);
    }

    public Nutrition saveNutrition(Nutrition nutrition) {
        return nutritionRepository.save(nutrition);
    }

    public void deleteNutrition(Long id) {
        nutritionRepository.deleteById(id);
    }

}
