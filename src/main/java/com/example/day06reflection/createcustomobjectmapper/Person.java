package com.example.day06reflection.createcustomobjectmapper;

public class Person {
    private String name;
    private int age;

    public Person() {}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person {Name = '" + name + "', Age =" + age + "}";
    }
}

