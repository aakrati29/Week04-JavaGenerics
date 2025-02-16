package com.example.day06reflection.createcustomobjectmapper;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Aakrati");
        properties.put("age", 21);

        Person person = CustomObjectMapper.toObject(Person.class, properties);

        System.out.println(person);
    }
}

