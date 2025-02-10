package com.example.day01generics.smartwarehousemanagement;

public class Main {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items to storage
        electronicsStorage.addItem(new Electronics("Laptop", 75000, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 50000, "Samsung"));

        groceriesStorage.addItem(new Groceries("Milk", 50, "2025-01-15"));
        groceriesStorage.addItem(new Groceries("Rice", 120, "2026-06-10"));

        furnitureStorage.addItem(new Furniture("Chair", 3000, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 7000, "Metal"));

        // Displaying all items using the wildcard method
        System.out.println("Electronics:");
        WarehouseUtility.displayAllItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries:");
        WarehouseUtility.displayAllItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture:");
        WarehouseUtility.displayAllItems(furnitureStorage.getAllItems());
    }
}
