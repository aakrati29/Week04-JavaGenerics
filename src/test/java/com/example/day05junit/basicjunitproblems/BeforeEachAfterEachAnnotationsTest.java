package com.example.day05junit.basicjunitproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BeforeEachAfterEachAnnotationsTest {

    private BeforeEachAndAfterEachAnnotations db;

    @BeforeEach
    void setUp() {
        db = new BeforeEachAndAfterEachAnnotations();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(db.isConnected(), "Database should be connected in @BeforeEach");
    }

    @Test
    void testConnectionCanBeClosed() {
        db.disconnect();
        assertFalse(db.isConnected(), "Database should be disconnected after calling disconnect()");
    }
}

