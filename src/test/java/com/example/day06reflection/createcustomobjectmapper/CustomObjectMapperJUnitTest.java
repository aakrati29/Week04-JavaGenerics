package com.example.day06reflection.createcustomobjectmapper;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class CustomObjectMapperJUnitTest {

    @Test
    void testToObject() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Aakrati");
        properties.put("age", 25);

        Person person = CustomObjectMapper.toObject(Person.class, properties);

        assertNotNull(person);
        assertEquals("Aakrati", person.getName());
        assertEquals(25, person.getAge());
    }
}

