package com.example.day06annotations.usedeprecated;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LegacyAPITest {

    @Test
    @SuppressWarnings("deprecation")
    void testOldFeature() {
        // Capture system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LegacyAPI api = new LegacyAPI();
        api.oldFeature();

        System.setOut(System.out);

        String actualOutput = outputStream.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "Warning: This feature is deprecated.";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testNewFeature() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LegacyAPI api = new LegacyAPI();
        api.newFeature();

        System.setOut(System.out);

        String actualOutput = outputStream.toString().trim().replace("\r\n", "\n");
        String expectedOutput = "This is the new and improved feature.";

        assertEquals(expectedOutput, actualOutput);
    }
}

