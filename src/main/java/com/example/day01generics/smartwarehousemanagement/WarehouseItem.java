package com.example.day01generics.smartwarehousemanagement;

abstract class WarehouseItem {
    private String itemName;
    private double price;

    WarehouseItem(String itemName, double price){
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName(){
        return itemName;
    }

    public double getPrice(){
        return price;
    }

    public String toString(){
        return "Item name is : " + itemName + "with price : " + price + "rs.";
    }
}
