package com.example.day01generics.personalizedmealplangenerator;

public class Meal <T extends MealPlan>{
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public String generatePersonalizedMealPlan() {
        return mealPlan.generateMealPlan();
    }
}
