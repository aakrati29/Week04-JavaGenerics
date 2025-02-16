package com.example.day06reflection.Generateajsonrepresentation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonConverterTest {

    @Test
    void testToJson() {
        Person person = new Person("Aakrati", 25, false);
        String expectedJson = "{\"name\": \"Aakrati\", \"age\": 25, \"isActive\": false}";

        // Normalize whitespace before comparison
        String actualJson = JsonConverter.toJson(person).replaceAll("\\s", "");

        assertEquals(expectedJson.replaceAll("\\s", ""), actualJson, "JSON output is incorrect");
    }
}
