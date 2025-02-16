package com.example.day06reflection.dependencyinjection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DIContainerTest {

    @Test
    void testDependencyInjection() throws Exception {
        InjectContainer diContainer = new InjectContainer();

        diContainer.register(EmailService.class);

        ServiceForUsers userService = new ServiceForUsers();

        diContainer.injectDependencies(userService);

        assertNotNull(userService.emailService, "Dependency injection failed!");
    }
}
