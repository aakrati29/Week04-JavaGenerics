package com.example.day06reflection.createcustomobjectmapper;

import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);

                    field.set(instance, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Field not found : " + fieldName);
                }
            }
            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create object : " + e.getMessage(), e);
        }
    }
}

