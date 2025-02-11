package com.example.day01generics.dynamiconlinemarketplace;

public class Books extends Product{
    private String category;

    public Books(String name, double price, String category) {
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
