package com.example.day06reflection.accessandmodifystaticfields;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> configClass = Configuration.class;

            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            apiKeyField.setAccessible(true);

            apiKeyField.set(null, "NEW_SECRET_KEY");

            System.out.println("Updated API_KEY : " + Configuration.getApiKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

