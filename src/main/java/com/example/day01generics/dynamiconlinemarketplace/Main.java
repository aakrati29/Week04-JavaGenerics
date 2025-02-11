package com.example.day01generics.dynamiconlinemarketplace;


public class Main {
    static <T extends Product> void getDiscount(T product, double discount){
        double discountAmount = product.getPrice()*(discount/100);
        product.setPrice(product.getPrice()-discountAmount);

    }
    public static void main(String[] args) {
        ProductCatalog<Books> booksProductCatalog = new ProductCatalog<>();
        booksProductCatalog.addProduct(new Books("JAVA",100,"Education"));
        booksProductCatalog.addProduct(new Books("Ramayan",0,"Ritual"));

        ProductCatalog<Clothing> clothingProductCatalog = new ProductCatalog<>();
        clothingProductCatalog.addProduct(new Clothing("T-Shirt",500,"MEN"));
        clothingProductCatalog.addProduct(new Clothing("One piece",1500,"WOMEN"));

        ProductCatalog<Gadgets> gadgetsProductCatalog = new ProductCatalog<>();
        gadgetsProductCatalog.addProduct(new Gadgets("Remote",100,"Electronics"));
        gadgetsProductCatalog.addProduct(new Gadgets("Video game",10000,"Games"));

        getDiscount(booksProductCatalog.getAllProduct().getFirst(),10);
        getDiscount(clothingProductCatalog.getAllProduct().get(1), 20);
        getDiscount(gadgetsProductCatalog.getAllProduct().get(1), 30);

        booksProductCatalog.getAllProduct().forEach(System.out::println);
        clothingProductCatalog.getAllProduct().forEach(System.out::println);
        gadgetsProductCatalog.getAllProduct().forEach(System.out::println);
    }
}
