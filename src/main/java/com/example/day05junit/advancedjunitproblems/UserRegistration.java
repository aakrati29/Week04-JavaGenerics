package com.example.day05junit.advancedjunitproblems;

import java.util.regex.Pattern;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password must have at least 8 characters, one uppercase letter, and one digit");
        }
        System.out.println("User " + "'" + username + "'" + " registered successfully "  + " with email " + email);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }

    public static void main(String[] args) {
        UserRegistration userReg = new UserRegistration();
        userReg.registerUser("Aakrati", "aakrati.doe@example.com", "Aakrati@#21"); // Success
    }
}

