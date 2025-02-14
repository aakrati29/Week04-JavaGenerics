package com.example.day04exceptions.uncheckedexception;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class RuntimeExceptionTest {

    @Test
    void testCheckArithmeticEx_DivideByZero() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Test division by zero
            RuntimeException.checkArithmeticEx(10, 0);
            String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
            String expectedOutput = "Arithmetic exception occurs: / by zero";

            assertEquals(expectedOutput, actualOutput, "Mismatch in ArithmeticException output!");
        } finally {
            System.setOut(originalOut); // Restore System.out
        }
    }

    @Test
    void testCheckArithmeticEx_ValidDivision() {
        // Should not throw an exception
        assertDoesNotThrow(() -> RuntimeException.checkArithmeticEx(10, 2));
    }

    @Test
    void testCheckInputMismatchEx_ValidInput() {
        // Should not throw an exception as there is no actual InputMismatchException occurring
        assertDoesNotThrow(() -> RuntimeException.checkInputMismatchEx(5));
    }
}

