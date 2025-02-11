package com.example.day01generics.dynamiconlinemarketplace;

import java.util.ArrayList;
import java.util.List;

class ProductCatalog<T extends Product> {
    List<T> list = new ArrayList<>();

    public void addProduct(T product){
        list.add(product);
    }

    public List<T> getAllProduct(){
        return list;
    }


}
