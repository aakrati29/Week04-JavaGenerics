package com.example.day06reflection.Generateajsonrepresentation;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Aakrati", 25, true);
        String jsonString = JsonConverter.toJson(person);
        System.out.println(jsonString);
    }
}

