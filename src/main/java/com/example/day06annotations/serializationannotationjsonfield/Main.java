package com.example.day06annotations.serializationannotationjsonfield;

public class Main {
    public static void main(String[] args) {
        Users user = new Users("Aakrati", "aakrati@example.com", 21);

        try {
            String json = JsonSerializer.serialize(user);
            System.out.println("Serialized JSON: " + json);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

