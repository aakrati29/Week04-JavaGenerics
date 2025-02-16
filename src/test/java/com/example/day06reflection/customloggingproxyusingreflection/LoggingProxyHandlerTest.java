package com.example.day06reflection.customloggingproxyusingreflection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoggingProxyHandlerTest {

    @Test
    void testProxyLogging() {
        Greeting greeting = new GreetingImplementation();

        Greeting proxyGreeting = LoggingProxyHandler.createProxy(greeting, Greeting.class);

        String result = proxyGreeting.sayHello("Aakrati");

        assertEquals("Hello, Aakrati!", result);
    }
}

