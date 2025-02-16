package com.example.day06reflection.accessandmodifystaticfields;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class AccessAndModifyStaticFieldTest {

    @Test
    void testModifyApiKey() throws Exception {
        Class<?> configClass = Configuration.class;

        Field apiKeyField = configClass.getDeclaredField("API_KEY");

        apiKeyField.setAccessible(true);

        apiKeyField.set(null, "TEST_SECRET_KEY");

        assertEquals("TEST_SECRET_KEY", Configuration.getApiKey(), "API_KEY should be updated");
    }
}

