package com.example.day01generics.smartwarehousemanagement;

import javax.swing.text.SimpleAttributeSet;

public class Electronics extends WarehouseItem{
    private String brand;

    Electronics(String itemName, double price, String brand) {
        super(itemName, price);
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public String toString(){
        return super.toString() + " Brand is : " + brand;
    }
}
