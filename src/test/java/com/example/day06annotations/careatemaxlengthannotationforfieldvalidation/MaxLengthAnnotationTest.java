package com.example.day06annotations.careatemaxlengthannotationforfieldvalidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxLengthAnnotationTest {

    @Test
    void testValidUsername() {
        Users user = new Users("JohnDoe");
        assertEquals("JohnDoe", user.getUsername());
    }

    @Test
    void testInvalidUsernameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Users("ThisUsernameIsTooLong");
        });

        assertEquals("Username exceeds max length of 10", exception.getMessage());
    }
}

