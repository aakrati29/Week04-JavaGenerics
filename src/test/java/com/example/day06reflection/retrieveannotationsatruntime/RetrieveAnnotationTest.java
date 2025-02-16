package com.example.day06reflection.retrieveannotationsatruntime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RetrieveAnnotationTest {

    @Test
    void testAuthorAnnotationRetrieval() {
        Class<?> clazz = AnnotatedClass.class;

        assertTrue(clazz.isAnnotationPresent(Author.class), "Author annotation should be present");

        Author authorAnnotation = clazz.getAnnotation(Author.class);
        assertEquals("Aakrati Barsaiyan", authorAnnotation.name(), "Author name should match");
    }
}

