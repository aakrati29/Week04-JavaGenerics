package com.example.day06annotations.rolebasedaccessontrol;

public class Main {
    public static void main(String[] args) {
        Users adminUser = new Users("Ram", "ADMIN");
        Users normalUser = new Users("Aakrati", "USER");

        SecureService service = new SecureService();

        SecureService.executeIfAllowed(adminUser, service, "performAdminTask");

        SecureService.executeIfAllowed(normalUser, service, "performAdminTask");

        SecureService.executeIfAllowed(normalUser, service, "performUserTask");

        SecureService.executeIfAllowed(normalUser, service, "performPublicTask");
    }
}

