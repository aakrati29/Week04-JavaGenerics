package com.example.day06annotations.rolebasedaccessontrol;

import java.lang.reflect.Method;

public class SecureService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER")
    public void performUserTask() {
        System.out.println("User task executed successfully!");
    }

    public void performPublicTask() {
        System.out.println("Public task executed successfully!");
    }

    public static void executeIfAllowed(Users user, Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (!roleAllowed.value().equals(user.getRole())) {
                    System.out.println("Access Denied! " + user.getUsername() + " does not have permission.");
                    return;
                }
            }
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

