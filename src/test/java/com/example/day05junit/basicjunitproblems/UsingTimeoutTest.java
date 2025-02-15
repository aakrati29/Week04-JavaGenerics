package com.example.day05junit.basicjunitproblems;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import java.time.Duration;

public class UsingTimeoutTest {
    private final UsingTimeout performanceTests = new UsingTimeout();

    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS) // Increased timeout (test passes)
    void testLongRunningTaskTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(4), () -> performanceTests.longRunningTask());
    }
}
