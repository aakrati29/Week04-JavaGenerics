package com.example.day01generics.personalizedmealplangenerator;

public class Vegetarian implements MealPlan {
    @Override
    public String generateMealPlan() {
        return "Vegetarian Meal Plan: A variety of plant-based dishes.";
    }
}
