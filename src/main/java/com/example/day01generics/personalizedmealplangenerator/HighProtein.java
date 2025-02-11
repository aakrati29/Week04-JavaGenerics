package com.example.day01generics.personalizedmealplangenerator;

public class HighProtein implements MealPlan{

    @Override
    public String generateMealPlan() {
        return "Protein-Packed,Muscle Fuel,Power Meals,Gains Booster,Strength Plate";
    }
}
