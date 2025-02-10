package com.example.day01generics.smartwarehousemanagement;

public class Groceries extends WarehouseItem{
    private String expireDate;

    Groceries(String itemName, double price, String expireDate) {
        super(itemName, price);
        this.expireDate = expireDate;
    }

    public String getExpireDate(){
        return expireDate;
    }

    public String toString(){
        return super.toString() + " Expire date is : " + expireDate;
    }
}
