package com.example.day01generics.personalizedmealplangenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MealPlanTest {

    @Test
    void testVegetarianMealPlan() {
        Vegetarian vegetarian = new Vegetarian();
        assertEquals("Vegetarian Meal Plan: A variety of plant-based dishes.", vegetarian.generateMealPlan());
    }

    @Test
    void testVeganMealPlan() {
        Vegan vegan = new Vegan();
        assertEquals("Pure Plant-Powered, 100% Plant-Based,Compassionate Cuisine,Dairy-Free Feast, Earth-Friendly Eats", vegan.generateMealPlan());
    }

    @Test
    void testKetoMealPlan() {
        Keto keto = new Keto();
        assertEquals("Low-Carb Fuel,Fat-Fueled Meals,Ketogenic Bites,Carb-Conscious,Keto-Friendly Delights", keto.generateMealPlan());
    }

    @Test
    void testHighProteinMealPlan() {
        HighProtein highProtein = new HighProtein();
        assertEquals("Protein-Packed,Muscle Fuel,Power Meals,Gains Booster,Strength Plate", highProtein.generateMealPlan());
    }

    @Test
    void testMealClass() {
        Meal<Vegetarian> vegetarianMeal = new Meal<>(new Vegetarian());
        assertEquals("Vegetarian Meal Plan: A variety of plant-based dishes.", vegetarianMeal.generatePersonalizedMealPlan());
    }

    @Test
    void testMainGenerateMealPlan() {
        assertEquals("Validating meal plan...\nVegetarian Meal Plan: A variety of plant-based dishes.", Main.generateMealPlan(new Vegetarian()));
        assertEquals("Validating meal plan...\nPure Plant-Powered, 100% Plant-Based,Compassionate Cuisine,Dairy-Free Feast, Earth-Friendly Eats", Main.generateMealPlan(new Vegan()));
        assertEquals("Validating meal plan...\nLow-Carb Fuel,Fat-Fueled Meals,Ketogenic Bites,Carb-Conscious,Keto-Friendly Delights", Main.generateMealPlan(new Keto()));
        assertEquals("Validating meal plan...\nProtein-Packed,Muscle Fuel,Power Meals,Gains Booster,Strength Plate", Main.generateMealPlan(new HighProtein()));
    }
}

