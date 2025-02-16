package com.example.day06annotations.rolebasedaccessontrol;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class RoleBasedAnnotationTest {

    @Test
    void testAdminAccess() {
        Users admin = new Users("Ram", "ADMIN");
        SecureService service = new SecureService();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SecureService.executeIfAllowed(admin, service, "performAdminTask");

        assertTrue(outputStream.toString().contains("Admin task executed successfully!"));
    }

    @Test
    void testUserDeniedAdminAccess() {
        Users user = new Users("Aakrati", "USER");
        SecureService service = new SecureService();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SecureService.executeIfAllowed(user, service, "performAdminTask");

        assertTrue(outputStream.toString().contains("Access Denied! Bob does not have permission."));
    }

    @Test
    void testUserAccessToUserTask() {
        Users user = new Users("Ankit", "USER");
        SecureService service = new SecureService();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SecureService.executeIfAllowed(user, service, "performUserTask");

        assertTrue(outputStream.toString().contains("User task executed successfully!"));
    }

    @Test
    void testPublicTaskAccess() {
        Users user = new Users("Anand", "GUEST");
        SecureService service = new SecureService();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SecureService.executeIfAllowed(user, service, "performPublicTask");

        assertTrue(outputStream.toString().contains("Public task executed successfully!"));
    }
}

