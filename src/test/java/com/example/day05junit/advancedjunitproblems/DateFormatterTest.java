package com.example.day05junit.advancedjunitproblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    void testValidDateFormatting() {
        assertEquals("16-02-2024", DateFormatter.formatDate("2024-02-16"), "Valid date should be formatted correctly");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), "Valid date should be formatted correctly");
        assertEquals("31-12-1999", DateFormatter.formatDate("1999-12-31"), "Valid date should be formatted correctly");
    }

    @Test
    void testInvalidDateFormatting() {
        assertEquals("Invalid Date Format", DateFormatter.formatDate("2024/02/16"), "Invalid format should return error");
        assertEquals("Invalid Date Format", DateFormatter.formatDate("16-02-2024"), "Invalid format should return error");
        assertEquals("Invalid Date Format", DateFormatter.formatDate("abcd-ef-gh"), "Invalid format should return error");
    }
}

