package com.example.day06annotations.suppressuncheckedwarningsannotation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UncheckedWarningTest {

    @Test
    @SuppressWarnings("unchecked")
    void testCreateAList() {
        // Capture system output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        UncheckedWarning uncheckedWarning = new UncheckedWarning();
        uncheckedWarning.createAList();

        System.setOut(System.out);

        String actualOutput = outputStream.toString().trim();

        assertTrue(actualOutput.contains("The list is : [Aakrati, A, 3]"));
    }
}

