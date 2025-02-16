package com.example.day06annotations.serializationannotationjsonfield;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {
    public static String serialize(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Map<String, String> jsonElements = new HashMap<>();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonElements.put(annotation.name(), field.get(obj).toString());
            }
        }

        StringBuilder jsonBuilder = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            jsonBuilder.append("\"").append(entry.getKey()).append("\":")
                    .append("\"").append(entry.getValue()).append("\", ");
        }

        if (jsonBuilder.length() > 1) {
            jsonBuilder.setLength(jsonBuilder.length() - 2);
        }
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}

