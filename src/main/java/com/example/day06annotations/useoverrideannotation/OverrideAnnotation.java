package com.example.day06annotations.useoverrideannotation;

abstract class Animal{
    public void makeSound(){
        System.out.println("Animal make sounds");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Dog is barking");
    }
}
public class OverrideAnnotation {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}
