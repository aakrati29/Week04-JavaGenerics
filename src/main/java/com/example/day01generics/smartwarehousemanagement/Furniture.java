package com.example.day01generics.smartwarehousemanagement;

public class Furniture extends WarehouseItem{
    private String material;

    Furniture(String itemName, double price, String material) {
        super(itemName, price);
        this.material = material;
    }

    public String getMaterial(){
        return material;
    }

    public String toString(){
        return super.toString() + " Material is : " + material;
    }
}
