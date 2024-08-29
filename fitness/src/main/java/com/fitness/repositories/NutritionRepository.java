package com.fitness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.models.Nutrition;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {

}
