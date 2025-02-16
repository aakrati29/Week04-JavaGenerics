package com.example.day06annotations.serializationannotationjsonfield;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JsonSerializerTest {

    @Test
    void testJsonSerialization() throws IllegalAccessException {
        Users user = new Users("Aakrati", "aakrati@example.com", 30);
        String expectedJson = "{\"user_email\":\"aakrati@example.com\", \"user_name\":\"Aakrati\"}";

        String actualJson = JsonSerializer.serialize(user);

        assertEquals(expectedJson, actualJson);
    }
}


