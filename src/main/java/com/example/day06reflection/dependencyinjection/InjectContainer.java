package com.example.day06reflection.dependencyinjection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InjectContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void register(Class<T> clazz) throws Exception {
        instances.put(clazz, clazz.getDeclaredConstructor().newInstance());
    }

    public void injectDependencies(Object object) throws Exception {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);

                if (dependency == null) {
                    throw new RuntimeException("No registered instance for " + fieldType.getName());
                }

                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }
}

