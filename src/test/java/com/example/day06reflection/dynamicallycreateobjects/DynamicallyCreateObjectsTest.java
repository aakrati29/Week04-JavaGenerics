package com.example.day06reflection.dynamicallycreateobjects;


import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class DynamicallyCreateObjectsTest {

    @Test
    void testStudentDisplayMethod() {
        try {
            Class<?> studentClass = Students.class;

            Constructor<?> constructor = studentClass.getDeclaredConstructor();

            Object studentInstance = constructor.newInstance();

            Method displayMethod = studentClass.getMethod("display");
            assertNotNull(displayMethod, "display method should be present.");

            displayMethod.invoke(studentInstance);

        } catch (Exception e) {
            fail("Exception occurred while testing display method: " + e.getMessage());
        }
    }
}

