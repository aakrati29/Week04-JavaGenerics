package com.example.day06reflection.accessprivatefield;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            person.displayAge();

            Field ageField = Person.class.getDeclaredField("age");

            ageField.setAccessible(true);

            ageField.set(person, 22);

            int modifiedAge = (int) ageField.get(person);
            System.out.println("Modified Age: " + modifiedAge);

            person.displayAge();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

