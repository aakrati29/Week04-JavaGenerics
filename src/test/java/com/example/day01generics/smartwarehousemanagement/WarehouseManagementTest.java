package com.example.day01generics.smartwarehousemanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseManagementTest {

    private Storage<Electronics> electronicsStorage;
    private Storage<Groceries> groceriesStorage;
    private Storage<Furniture> furnitureStorage;

    @BeforeEach
    void setUp() {
        electronicsStorage = new Storage<>();
        groceriesStorage = new Storage<>();
        furnitureStorage = new Storage<>();
    }

    @Test
    void testAddItemToElectronicsStorage() {
        Electronics laptop = new Electronics("Laptop", 75000, "Dell");
        electronicsStorage.addItem(laptop);

        List<Electronics> items = electronicsStorage.getAllItems();
        assertEquals(1, items.size());
        assertEquals(laptop, items.get(0));
    }

    @Test
    void testAddItemToGroceriesStorage() {
        Groceries milk = new Groceries("Milk", 50, "2025-01-15");
        groceriesStorage.addItem(milk);

        List<Groceries> items = groceriesStorage.getAllItems();
        assertEquals(1, items.size());
        assertEquals(milk, items.get(0));
    }

    @Test
    void testAddItemToFurnitureStorage() {
        Furniture chair = new Furniture("Chair", 3000, "Wood");
        furnitureStorage.addItem(chair);

        List<Furniture> items = furnitureStorage.getAllItems();
        assertEquals(1, items.size());
        assertEquals(chair, items.get(0));
    }

    @Test
    void testDisplayAllItems() {
        electronicsStorage.addItem(new Electronics("Smartphone", 50000, "Samsung"));
        groceriesStorage.addItem(new Groceries("Rice", 120, "2026-06-10"));
        furnitureStorage.addItem(new Furniture("Table", 7000, "Metal"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            WarehouseUtility.displayAllItems(electronicsStorage.getAllItems());
            WarehouseUtility.displayAllItems(groceriesStorage.getAllItems());
            WarehouseUtility.displayAllItems(furnitureStorage.getAllItems());

            String actualOutput = outputStream.toString().trim();
            System.setOut(originalOut); // Restore System.out

            String expectedOutput = """
                Item name is : Smartphonewith price : 50000.0rs. Brand is : Samsung Item name is : Ricewith price : 120.0rs. Expire date is : 2026-06-10 Item name is : Tablewith price : 7000.0rs. Material is : Metal
            """.trim();

            // Normalize whitespace before assertion
            assertEquals(expectedOutput.replaceAll("\\s+", " "), actualOutput.replaceAll("\\s+", " "));
        } finally {
            System.setOut(originalOut);
        }
    }
}
