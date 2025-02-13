package com.example.day02collection.implementashoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCard cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCard();
        cart.addProduct("Laptop", 800.0, 1);
        cart.addProduct("Phone", 500.0, 2);
        cart.addProduct("Headphones", 200.0, 1);
        cart.addProduct("Mouse", 50.0, 3);
    }

    @Test
    public void testAddProduct() {
        // Verify the product is added correctly
        assertEquals(1, cart.cart.get("Laptop"));
        assertEquals(2, cart.cart.get("Phone"));
        assertEquals(1, cart.cart.get("Headphones"));
        assertEquals(3, cart.cart.get("Mouse"));

        // Verify the product prices are set
        assertEquals(800.0, cart.productPrices.get("Laptop"));
        assertEquals(500.0, cart.productPrices.get("Phone"));
    }

    @Test
    public void testRemoveProduct() {
        cart.removeProduct("Phone");

        // Verify the product is removed from the cart
        assertFalse(cart.cart.containsKey("Phone"));
        assertFalse(cart.productPrices.containsKey("Phone"));

        // Verify the product is removed from the sorted list
        assertFalse(cart.sortedByPrice.containsKey(500.0));
    }

    @Test
    public void testRemoveNonExistingProduct() {
        cart.removeProduct("NonExistingProduct");

        // Ensure nothing is removed if the product doesn't exist
        assertTrue(cart.cart.containsKey("Laptop"));
    }

    @Test
    public void testGetTotalPrice() {
        double total = cart.getTotalPrice();

        // Verify the total price calculation
        assertEquals(800.0 + 500.0 * 2 + 200.0 + 50.0 * 3, total);
    }

    @Test
    public void testSortedByPrice() {
        // Ensure products are sorted by price
        cart.addProduct("Tablet", 300.0, 2);

        // Verify sorting by price
        assertTrue(cart.sortedByPrice.containsKey(50.0)); // Mouse should be in this price range
        assertTrue(cart.sortedByPrice.containsKey(200.0)); // Headphones should be in this price range
        assertTrue(cart.sortedByPrice.containsKey(800.0)); // Laptop should be in this price range
    }

    private String getCartContents() {
        // Capture the cart display output
        cart.displayCart();
        return "Captured Cart Contents";
    }

    private String getSortedContents() {
        // Capture the sorted by price output
        cart.displaySortedByPrice();
        return "Captured Sorted Contents";
    }
}

