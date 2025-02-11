package com.example.day01generics.dynamiconlinemarketplace;

abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getCategory(){
        return name;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    @Override
    public String toString(){
        return "Name : " + name + ", Price : " + price;
    }
}
