package com.example.day06annotations.annotationtomarkimportantmethods;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class ImportantMethodsTest {

    @Test
    void testImportantMethodAnnotations() {
        Method[] methods = ApplicationService.class.getDeclaredMethods();
        int count = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);

                if (method.getName().equals("processCriticalData")) {
                    assertEquals("HIGH", annotation.level());
                } else if (method.getName().equals("generateReport")) {
                    assertEquals("MEDIUM", annotation.level());
                }
                count++;
            }
        }

        assertEquals(2, count); // Ensure exactly 2 methods are annotated
    }
}

