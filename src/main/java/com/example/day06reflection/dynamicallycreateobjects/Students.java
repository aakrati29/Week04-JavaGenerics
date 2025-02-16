package com.example.day06reflection.dynamicallycreateobjects;

class Students {
    private String name;

    public Students() {
        this.name = "Default Student";
    }

    public Students(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name : " + name);
    }
}
