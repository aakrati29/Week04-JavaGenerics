package com.example.day06reflection.Generateajsonrepresentation;

import java.lang.reflect.Field;

public class JsonConverter {

    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        int count = 0;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (count > 0) {
                    json.append(", ");
                }
                json.append("\"").append(field.getName()).append("\" : ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                count++;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}

