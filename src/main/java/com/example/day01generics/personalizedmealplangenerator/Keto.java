package com.example.day01generics.personalizedmealplangenerator;

public class Keto implements MealPlan{

    @Override
    public String generateMealPlan() {
        return "Low-Carb Fuel,Fat-Fueled Meals,Ketogenic Bites,Carb-Conscious,Keto-Friendly Delights";
    }
}
