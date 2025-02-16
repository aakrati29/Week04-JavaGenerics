package com.example.day06reflection.accessprivatefield;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

class AccessPrivateFieldTest {

    @Test
    void testPrivateFieldModification() {
        try {
            Person person = new Person(25);

            Field ageField = Person.class.getDeclaredField("age");

            ageField.setAccessible(true);

            ageField.set(person, 30);

            int modifiedAge = (int) ageField.get(person);
            assertEquals(30, modifiedAge, "Age should be modified to 30");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testInvalidFieldAccess() {
        Exception exception = assertThrows(NoSuchFieldException.class, () -> {
            // Attempt to access a non-existing field
            Person.class.getDeclaredField("nonExistentField");
        });

        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }
}

