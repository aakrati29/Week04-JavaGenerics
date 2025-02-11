package com.example.day01generics.personalizedmealplangenerator;

public class Main {
    public static <T extends MealPlan> String generateMealPlan(T mealPlan) {
        return "Validating meal plan...\n" + mealPlan.generateMealPlan();
    }

    public static void main(String[] args) {
        Meal<Vegetarian> vegetarian = new Meal<>(new Vegetarian());
        Meal<Vegan> vegan = new Meal<>(new Vegan());
        Meal<Keto> keto = new Meal<>(new Keto());
        Meal<HighProtein> highProtein = new Meal<>(new HighProtein());

        System.out.println("\n"+vegetarian.generatePersonalizedMealPlan());
        System.out.println("\n"+vegan.generatePersonalizedMealPlan());
        System.out.println("\n"+keto.generatePersonalizedMealPlan());
        System.out.println("\n"+highProtein.generatePersonalizedMealPlan());

        System.out.println("\n"+generateMealPlan(new Vegetarian()));
        System.out.println("\n"+generateMealPlan(new Vegan()));
        System.out.println("\n"+generateMealPlan(new Keto()));
        System.out.println("\n"+generateMealPlan(new HighProtein()));
    }
}