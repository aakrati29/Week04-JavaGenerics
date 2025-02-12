package com.example.day01generics.dynamiconlinemarketplace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogTest {

    private ProductCatalog<Books> booksCatalog;
    private ProductCatalog<Clothing> clothingCatalog;
    private ProductCatalog<Gadgets> gadgetsCatalog;

    @BeforeEach
    void setUp() {
        booksCatalog = new ProductCatalog<>();
        clothingCatalog = new ProductCatalog<>();
        gadgetsCatalog = new ProductCatalog<>();

        booksCatalog.addProduct(new Books("JAVA", 100, "Education"));
        booksCatalog.addProduct(new Books("Ramayan", 200, "Ritual"));

        clothingCatalog.addProduct(new Clothing("T-Shirt", 500, "MEN"));
        clothingCatalog.addProduct(new Clothing("One piece", 1500, "WOMEN"));

        gadgetsCatalog.addProduct(new Gadgets("Remote", 100, "Electronics"));
        gadgetsCatalog.addProduct(new Gadgets("Video game", 10000, "Games"));
    }

    @Test
    void testAddAndRetrieveProducts() {
        List<Books> books = booksCatalog.getAllProduct();
        List<Clothing> clothing = clothingCatalog.getAllProduct();
        List<Gadgets> gadgets = gadgetsCatalog.getAllProduct();

        assertEquals(2, books.size());
        assertEquals(2, clothing.size());
        assertEquals(2, gadgets.size());

        assertEquals("Education", books.get(0).getCategory());
        assertEquals("WOMEN", clothing.get(1).getCategory());
        assertEquals("Games", gadgets.get(1).getCategory());
    }

    @Test
    void testDiscountApplication() {
        Main.getDiscount(booksCatalog.getAllProduct().get(0), 10); // 10% discount on JAVA
        Main.getDiscount(clothingCatalog.getAllProduct().get(1), 20); // 20% discount on One piece
        Main.getDiscount(gadgetsCatalog.getAllProduct().get(1), 30); // 30% discount on Video game

        assertEquals(90, booksCatalog.getAllProduct().get(0).getPrice(), 0.01);
        assertEquals(1200, clothingCatalog.getAllProduct().get(1).getPrice(), 0.01);
        assertEquals(7000, gadgetsCatalog.getAllProduct().get(1).getPrice(), 0.01);
    }
}

