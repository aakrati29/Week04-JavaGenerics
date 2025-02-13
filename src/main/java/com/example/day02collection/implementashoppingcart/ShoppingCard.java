package com.example.day02collection.implementashoppingcart;

import java.util.*;

public class ShoppingCard {
    public Map<String, Double> productPrices = new HashMap<>();
    public LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
    public TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    public void addProduct(String product, double price, int quantity) {
        productPrices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + quantity);

        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    public void removeProduct(String product) {
        if (cart.containsKey(product)) {
            double price = productPrices.get(product);
            cart.remove(product);
            productPrices.remove(product);

            // Remove from TreeMap
            sortedByPrice.get(price).remove(product);
            if (sortedByPrice.get(price).isEmpty()) {
                sortedByPrice.remove(price);
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Shopping Cart (Order of Addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " → Quantity: " + entry.getValue() + ", Price: " + productPrices.get(entry.getKey()));
        }
    }

    public void displaySortedByPrice() {
        System.out.println("Products Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " → Price: " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCard cart = new ShoppingCard();

        // Adding products
        cart.addProduct("Laptop", 800.0, 1);
        cart.addProduct("Phone", 500.0, 2);
        cart.addProduct("Headphones", 200.0, 1);
        cart.addProduct("Mouse", 50.0, 3);

        cart.displayCart();

        cart.displaySortedByPrice();

        System.out.println("Total Cart Price: $" + cart.getTotalPrice());

        cart.removeProduct("Phone");
        System.out.println("\nAfter Removing 'Phone':");
        cart.displayCart();
        cart.displaySortedByPrice();
    }
}

