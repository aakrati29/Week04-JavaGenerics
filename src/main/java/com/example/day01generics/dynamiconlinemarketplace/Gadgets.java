package com.example.day01generics.dynamiconlinemarketplace;

import java.awt.print.Book;

public class Gadgets extends Product{
    private String category;

    public Gadgets(String name, double price, String category) {
        super(name, price);
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    @Override
    public String toString(){
        return super.toString() + ", Category : " + category;
    }
}
